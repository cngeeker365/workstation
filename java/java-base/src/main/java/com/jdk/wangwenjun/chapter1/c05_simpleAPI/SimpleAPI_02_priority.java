package com.jdk.wangwenjun.chapter1.c05_simpleAPI;

import java.util.Optional;

/**
 * @author taobaibai
 * @create 2020-04-11 21:31
 */
public class SimpleAPI_02_priority {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                Optional.of(Thread.currentThread().getName()+"-Index("+i+")").ifPresent(System.out::println);
            }
        }, "t1");
        //最高优先级
        t1.setPriority(Thread.MAX_PRIORITY);

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                Optional.of(Thread.currentThread().getName()+"-Index("+i+")").ifPresent(System.out::println);
            }
        }, "t2");
        //普通优先级
        t2.setPriority(Thread.NORM_PRIORITY);

        Thread t3 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                Optional.of(Thread.currentThread().getName()+"-Index("+i+")").ifPresent(System.out::println);
            }
        }, "t3");
        //最低优先级
        t3.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }
}
