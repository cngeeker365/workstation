package com.springcloud.demo.userservice;

import com.springcloud.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping("/userlogin")
    public String login(){
        for (int i=0;i<10;i++){
            userFeignClient.login(i);
        }
        return "负载均衡demo";
        //return "收到结果:"+userFeignClient.login();
    }
/*    public String login(@RequestParam("name") String name, @RequestParam("pwd") String pwd){
        User user = new User();
        user.setUsername(name);
        user.setPassword(pwd);
        if(userFeignClient.login(user)){
//        if (userFeignClient.login(name, pwd)){
            return "hello, "+ name;
        }
        return "fail, "+ name;
    }*/
}
