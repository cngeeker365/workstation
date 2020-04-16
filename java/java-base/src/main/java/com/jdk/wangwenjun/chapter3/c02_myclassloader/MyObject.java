package com.jdk.wangwenjun.chapter3.c02_myclassloader;

/**
 * @author taobaibai
 * @create 2020-04-16 17:38
 */
public class MyObject {
    static {
        System.out.println("My Object Static Block.");
    }

    public String hello(){
        return "Hello World";
    }
}
