package com.jdk.wangwenjun.chapter1.c05_simpleAPI;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-11 21:40
 */
public class SimpleAPI_03_join {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            IntStream.range(1,10).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        }, "t1");
        Thread t2 = new Thread(()->{
            IntStream.range(1,10).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));
        }, "t2");

        t1.start();
        t2.start();
        //join：main线程等待 t1、t2 线程执行结束后，再执行; t1、t2之间没有先后
        //源码：-> join(0)
        t1.join();
        //main线程等100毫秒10纳秒后继续
        t2.join(100, 10);

        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1,10).forEach(i-> System.out.println(Thread.currentThread().getName()+"->"+i));

        //main线程等待main线程结束，程序一直在等，不退出
        //JettyHttpServer.start();
        Thread.currentThread().join();
    }
}
