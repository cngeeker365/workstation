package cn.shine365.demo.day01.controller;

import cn.shine365.demo.day01.domain.ServerSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author taobaibai
 * @create 2020-03-31 10:14
 */
@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @RequestMapping("/testMap")
    public Map<String,String> testMap(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Jerry");
        map.put("name","Tom");
        return map;
    }

    @Autowired
    private ServerSettings serverSettings;

    @GetMapping("/api/v1/testProperties")
    public Object testProperties(){
        return serverSettings;
    }

    @RequestMapping("/api2/v1/account")
    public Object account(){
        System.out.println("controller ---> account");
        Map<String,String> map = new HashMap<>();
        map.put("money","1000");
        return map;
    }
}
