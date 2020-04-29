package cn.dm.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author taobaibai
 * @create 2020-04-25 18:20
 */
@Configuration
public class DmConfiguration {
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
