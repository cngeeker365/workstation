package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_02 {
    private static Singleton_02 instance;
    private Singleton_02(){
        //empty
    }
    //线程不安全
    public static Singleton_02 getInstance(){
        if(null==instance){
            instance = new Singleton_02();
        }
        return Singleton_02.instance;
    }
}
