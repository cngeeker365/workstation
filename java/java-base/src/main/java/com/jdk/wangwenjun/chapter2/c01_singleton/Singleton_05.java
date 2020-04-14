package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_05 {
    //volatile：保证内存可见性、有序性，确保读前，写已全部完成，从而解决Double-Check空指针问题
    private static volatile Singleton_05 instance;

    private Singleton_05(){
        //empty
    }

    /**
     * Double-Check：解决懒加载、提高性能，带来了隐患（可能会因为编译器优化，而引起 空指针 异常）
     * @return
     */
    public static Singleton_05 getInstance(){
        if(null == instance){
            synchronized (Singleton_05.class){
                if(null==instance){
                    instance = new Singleton_05();
                }
            }
        }
        return Singleton_05.instance;
    }
}
