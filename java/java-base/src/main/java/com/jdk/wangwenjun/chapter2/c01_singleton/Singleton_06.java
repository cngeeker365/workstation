package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 *
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_06 {

    private Singleton_06(){
        //empty
    }

    private static class InstanceHoler{
        //static only init once
        private final static Singleton_06 instance = new Singleton_06();
    }

    //利用了静态内部类在使用时加载和初始化的特性，实现线程安全、懒加载、高效的单例模式
    public static Singleton_06 getInstance(){
        return InstanceHoler.instance;
    }
}
