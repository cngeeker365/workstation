package com.jdk.wangwenjun.chapter1.c11_threadGroup;

import java.util.Arrays;

/**
 * @author taobaibai
 * @create 2020-04-12 22:35
 */
public class ThreadGroupCreate {
    public static void main(String[] args) {
        //use the name
        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1"){
            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println(getThreadGroup().getName());
                        System.out.println(getThreadGroup().getParent());
                        System.out.println(getThreadGroup().getParent().activeCount());
                        Thread.sleep(10_000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();

        //use the parent and group name
//        ThreadGroup tg2 = new ThreadGroup(tg1, "TG2");
        ThreadGroup tg2 = new ThreadGroup("TG2");
        System.out.println(tg2.getName());
        System.out.println(tg2.getParent());
        Thread t2 = new Thread(tg2, "t2"){
            @Override
            public void run() {
                    try {
                        System.out.println(">>>" + tg1.getName());
                        Thread[] threads = new Thread[tg1.activeCount()];
                        tg1.enumerate(threads);
                        Arrays.asList(threads).forEach(System.out::println);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        };
        t2.start();

//        System.out.println(Thread.currentThread().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
