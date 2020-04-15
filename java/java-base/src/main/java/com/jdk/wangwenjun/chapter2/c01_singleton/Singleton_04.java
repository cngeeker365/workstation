package com.jdk.wangwenjun.chapter2.c01_singleton;

/**
 * @author taobaibai
 * @create 2020-04-13 22:37
 */
public class Singleton_04 {
    private static Singleton_04 instance;
    private Object obj1;
    private Object obj2;

    private Singleton_04(){
        obj1 = new Object();
        obj2 = new Object();
    }

    /**
     * Double-Check：解决懒加载、提高性能，带来了隐患（可能会因为编译器优化，而引起 空指针 异常）
     * 分析：
     *      JVM 堆内存中需要创建三个对象的空间
     *      instance            0x00000001
     *      obj1                0x00000002
     *      obj2                0x00000003
     *      这三个对象的开辟是允许重排序的
     *      Thread-1 在获取了 synchronized 锁后，进行了new，instance空间开辟好了，但obj1、obj2没有，此时锁释放
     *      Thread-2 获取锁，发现instance 不为空，即返回 instance，使用instance中的obj1、obj2，但此时并未完成，可能空指针
     *
     *      解决方法：
     *          使用 volatile 修饰 instance，确保 obj1、obj2 先于 instance 完成，禁止重排序
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
