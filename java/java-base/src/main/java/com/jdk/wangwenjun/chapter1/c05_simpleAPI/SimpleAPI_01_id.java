package com.jdk.wangwenjun.concurrency.chapter1;

import java.util.Optional;

/**
 * @author taobaibai
 * @create 2020-04-11 20:56
 */
public class SimpleAPI_01_id {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Optional.of("Hello").ifPresent(System.out::println);
            try {
                Thread.sleep(1_000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");
        t.start();
        Optional.of(t.getName()).ifPresent(System.out::println);
        Optional.of(t.getId()).ifPresent(System.out::println); //线程id
        Optional.of(t.getPriority()).ifPresent(System.out::println); //默认优先级为5

    }
}
