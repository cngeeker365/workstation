package cn.dm.service.impl;

import cn.dm.client.RestDmOrderClient;
import cn.dm.client.RestDmTradeClient;
import cn.dm.common.BaseException;
import cn.dm.exception.PayErrorCode;
import cn.dm.pojo.DmOrder;
import cn.dm.service.DmTradeService;
import cn.dm.vo.DmItemMessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-29 20:43
 */
@Service
public class DmTradeServiceImpl implements DmTradeService {
    private static final Logger logger = LoggerFactory.getLogger(DmTradeServiceImpl.class);
    @Resource
    private RestDmTradeClient restDmTradeClient;
    @Resource
    private RestDmOrderClient restDmOrderClient;

    @Override
    public Integer insertTrade(String orderNo, String tradeNo, Integer payMethod) throws Exception {
        //预留——根据订单编号获取订单信息
        DmOrder dmOrder = loadDmOrderByOrderNo(orderNo);
        //如果订单已经支付则终止后续业务的执行
        if (2 == dmOrder.getOrderType()) {
            return 0;
        }
        DmItemMessageVo dmItemMessageVo = new DmItemMessageVo();
        dmItemMessageVo.setTradeNo(tradeNo);
        dmItemMessageVo.setOrderNo(orderNo);
        dmItemMessageVo.setItemId(dmOrder.getItemId().toString());
        dmItemMessageVo.setUserId(dmOrder.getUserId().toString());
        dmItemMessageVo.setAmount(dmOrder.getTotalAmount());
        dmItemMessageVo.setPayMethod(payMethod);
        return restDmTradeClient.insertTrade(dmItemMessageVo);
    }

    @Override
    public DmOrder loadDmOrderByOrderNo(String orderNo) throws Exception {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderNo", orderNo);
        //根据订单编号查询订单——待引入
        List<DmOrder> dmOrders = restDmOrderClient.getDmOrderListByMap(params);
        if (dmOrders.size() == 0) {
            throw new BaseException(PayErrorCode.PAY_NO_EXISTS);
        }
        return dmOrders.get(0);
    }

    @Override
    public boolean processed(String orderNo, Integer flag) throws Exception {
        return restDmOrderClient.processed(orderNo, flag);
    }
}
