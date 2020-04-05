package cn.shine365.demo.day01.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author taobaibai
 * @create 2020-03-31 22:16
 */
@Configuration
public class CustomWebConfigure implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( new LoginIntercepter()).addPathPatterns("/api2/*/**").excludePathPatterns("/api2/xxx/**");
        registry.addInterceptor( new TwoIntercepter()).addPathPatterns("/api2/*/**");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
