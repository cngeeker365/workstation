package com.springcloud.demo.userservice;

import com.springcloud.demo.model.User;
import com.springcloud.demo.userservice.impl.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name="dm-user-provider", fallback = UserFeignClientFallback.class)
@FeignClient(name="dm-user-provider")
public interface UserFeignClient {

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String login();

//    @RequestMapping(value="/login", method= RequestMethod.POST)
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam("count") int count);
    //public String login();
//    public boolean login(@RequestBody User user);
//    public boolean login(@RequestParam("name") String name, @RequestParam("pwd") String pwd);
}
