package cn.dm.controller;

import cn.dm.common.BaseException;
import cn.dm.common.Constants;
import cn.dm.common.Dto;
import cn.dm.common.DtoUtil;
import cn.dm.config.WxPayConfig;
import cn.dm.exception.PayErrorCode;
import cn.dm.pojo.DmOrder;
import cn.dm.service.DmTradeService;
import cn.dm.util.WXPayConstants;
import cn.dm.util.WXPayRequest;
import cn.dm.util.WXPayUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-29 19:58
 */

@Controller
@RequestMapping("/api/wxpay")
public class WxPayController {

    @Resource
    private DmTradeService dmTradeService;

    @Resource
    private WxPayConfig wxPayConfig;

    /**
     * 请求统一下单API
     * @param orderNo
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/createqccode/{orderNo}", method = RequestMethod.GET)
    @ResponseBody
    public Dto createQccode(@PathVariable String orderNo) throws Exception{
        //获取订单信息
        DmOrder dmOrder = dmTradeService.loadDmOrderByOrderNo(orderNo);
        //封装请求下单API所需要的参数
        Map<String, String> data = new HashMap<String, String>();
        data.put("appid", wxPayConfig.getAppId());
        data.put("mch_id", wxPayConfig.getMchId()); //商户号
        data.put("body", "大觅网抢座下单");
        data.put("out_trade_no", orderNo);
        data.put("total_fee", "1");
        data.put("spbill_create_ip", "192.168.10.107");
        data.put("notify_url", wxPayConfig.getNotifyUrl());
        data.put("trade_type", "NATIVE");
        data.put("nonce_str", WXPayUtil.generateNonceStr());

        //sign签名
        String xml = WXPayUtil.generateSignedXml(data, wxPayConfig.getKey(), WXPayConstants.SignType.HMACSHA256);
        //带着这些参数去请求 统一下单api
        String resultXml = WXPayRequest.requestByXml(xml, "https://api.mch.weixin.qq.com/pay/unifiedorder", wxPayConfig.getMchId());
        //拿到返回结果中的code_url
        Map<String, String> resultMap = WXPayUtil.xmlToMap(resultXml);
        String resultCode = resultMap.get("result_code");
        String codeUrl = "";
        if("SUCCESS".equals(resultCode)){
            codeUrl = resultMap.get("code_url");
            return DtoUtil.returnDataSuccess(codeUrl);
        }else{
            throw new BaseException(PayErrorCode.PAY_ORDER_CODE);
        }
    }


    /**
     * 接收微信官方返回的支付结果通知
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/notify", method = RequestMethod.POST)
    @ResponseBody
    public String paymentCallBack(HttpServletRequest request) throws Exception {
        Map<String, String> result = new HashMap<String, String>();
        //接收微信官方返回的支付结果
        InputStream inputStream = request.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        String temp;
        StringBuilder stringBuilder =new StringBuilder();
        while ((temp = in.readLine()) != null){
            stringBuilder.append(temp);
        }
        in.close();
        inputStream.close();
        //获取map格式的支付结果
        Map<String, String> resultMap = WXPayUtil.xmlToMap(stringBuilder.toString());
        //签名验证是否正确
        boolean flag = WXPayUtil.isResponseSignatureValid(resultMap, wxPayConfig.getKey());
        if(flag){
            //获取支付结果中的result_code，根据此值判断是否进行自身业务实现
            String resultCode = resultMap.get("result_code");
            if ("SUCCESS".equals(resultCode)){
                //获取微信返回的交易号
                String transactionId = resultMap.get("transaction_id");
                //商户的订单编号
                String orderNo = resultMap.get("out_trade_no");
                if(!dmTradeService.processed(orderNo, Constants.PayMethod.WEIXIN)){
                    //实现自身业务
                    //1.往交易表里面插入记录
                    //2.发消息修改订单的状态
                    System.out.println("实现自身业务");
                }
                result.put("return_code", "SUCCESS");
                result.put("return_msg", "已接收");
            }else{
                result.put("return_code", "FAIL");
                result.put("return_msg", "已接收");
            }
        }else{
            result.put("return_code", "FAIL");
            result.put("return_msg", "已接收");
        }
        //return我们的接收状态
        return WXPayUtil.mapToXml(result);
    }
}
