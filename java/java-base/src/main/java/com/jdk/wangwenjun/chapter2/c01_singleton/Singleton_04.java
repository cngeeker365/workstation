package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_04 {
    private static Singleton_04 instance;
    private Singleton_04(){
        //empty
    }

    /**
     * Double-Check：解决懒加载、提高性能，带来了隐患（可能会因为编译器优化，而引起 空指针 异常）
     * @return
     */
    public static Singleton_04 getInstance(){
        if(null == instance){
            synchronized (Singleton_04.class){
                if(null==instance){
                    instance = new Singleton_04();
                }
            }
        }
        return Singleton_04.instance;
    }
}
