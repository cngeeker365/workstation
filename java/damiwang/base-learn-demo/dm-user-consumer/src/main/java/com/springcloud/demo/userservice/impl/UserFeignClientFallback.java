package com.springcloud.demo.userservice.impl;

import com.springcloud.demo.userservice.UserFeignClient;
import org.springframework.stereotype.Component;

//@Component
public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public String login(int count) {
        return "异常";
    }
}
