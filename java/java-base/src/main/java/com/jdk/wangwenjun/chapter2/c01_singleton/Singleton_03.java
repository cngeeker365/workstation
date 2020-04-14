package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_03 {
    private static Singleton_03 instance;
    private Singleton_03(){
        //empty
    }

    /**
     * sync 方式利用加锁，串行化的解决了数据安全，但初始化之后，不应该加锁了，性能不好
     * @return
     */
    public synchronized static Singleton_03 getInstance(){
        if(null==instance){
            instance = new Singleton_03();
        }
        return Singleton_03.instance;
    }
}
