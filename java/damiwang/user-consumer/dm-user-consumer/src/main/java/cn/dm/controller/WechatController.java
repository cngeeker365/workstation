package cn.dm.controller;

import cn.dm.common.UrlUtils;
import cn.dm.config.WechatConfig;
import cn.dm.service.DmLoginService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-04-29 14:05
 */
@Controller
@RequestMapping("/api/wechatlogin")
public class WechatController {
    @Resource
    private WechatConfig wechatConfig;
    @Resource
    private DmLoginService dmLoginService;
    /**
     * 微信登录第一步：请求获取code
     * @throws Exception
     */
    @RequestMapping(value = "/wechat/login")
    public void wechatLogin(HttpServletResponse response) throws Exception{
        //拼写请求获取code的地址
        StringBuilder codeUrl = new StringBuilder("https://open.weixin.qq.com/connect/qrconnect");
        codeUrl.append("?appid="+ wechatConfig.getAppId());
        codeUrl.append("&redirect_uri="+ "http%3a%2f%2fj19h691179.iok.la%2fapi%2fwechatlogin%2fwechat%2fcallBack");
        //固定写法
        codeUrl.append("&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect");
        //发送请求
        response.sendRedirect(codeUrl.toString());
    }

    /**
     * 微信登录第二步：请求获取access_token
     * @param code
     * @throws Exception
     */
    @RequestMapping("/wechat/callBack")
    public void wechatCallBack(@RequestParam String code, HttpServletResponse response) throws Exception{
        StringBuilder tokenUrl = new StringBuilder("https://api.weixin.qq.com/sns/oauth2/access_token");
        tokenUrl.append("?appid="+wechatConfig.getAppId());
        tokenUrl.append("&secret="+wechatConfig.getSecret());
        tokenUrl.append("&code="+code);
        tokenUrl.append("&grant_type=authorization_code");

        String json = UrlUtils.loadURL(tokenUrl.toString());
        Map<String, Object> tokenMap = JSON.parseObject(json, Map.class);

        //获取access_token
        String access_token = tokenMap.get("access_token").toString();
        //获取openId
        String openId = tokenMap.get("openid").toString();

        // 进行第三步：请求获取用户信息
        StringBuilder userInfoUrl = new StringBuilder("https://api.weixin.qq.com/sns/userinfo");
        userInfoUrl.append("?access_token=" + access_token);
        userInfoUrl.append("&openid="+openId);
        //发送请求获取用户信息
        String userInfoJson = UrlUtils.loadURL(userInfoUrl.toString());
        Map<String, Object> userInfoMap = JSON.parseObject(userInfoJson, Map.class);
        //实现自身的业务：
//                1.用户信息入库
//                2.获取用户的头像
//                3.生成token
//                4.将用户信息缓存到redis里面
        String token = dmLoginService.wechatLogin(userInfoMap, openId);
        //跳转到大觅网首页面
        String loginPage = "http://192.168.9.151:8888/#/?token="+token;
        response.sendRedirect(loginPage);
    }
}
