package cn.dm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author taobaibai
 * @create 2020-04-29 13:37
 */
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    private String appId;
    private String secret;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }
}
