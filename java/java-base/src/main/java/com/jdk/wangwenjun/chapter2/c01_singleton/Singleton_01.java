package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * 饿汉式：
 *   1. 线程安全
 *   2. 不能懒加载
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_01 {
    private static final Singleton_01 instance = new Singleton_01();
    private Singleton_01(){
        //empty
    }
    public static Singleton_01 getInstance(){
        return instance;
    }
}
