package com.jdk.wangwenjun.chapter4.c07_exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author taobaibai
 * @create 2020-04-18 19:40
 */
public class ExchangerExample01 {
    /**
     * V r = exchange(V v)
     *      v: indicate the object the current thread wanted to transfer
     *      r: indicate the other thread(pair) return object
     * Note:
     *   [1]    if the pair thread not reached exchange point, the thread will WAITING.
     *   [2]    use the Exchanger must be paired.
     * @param args
     */
    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " start.");
                String result = exchanger.exchange("I am come from T-A");
                System.out.println(Thread.currentThread().getName() + " get value [" + result + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        },"[A]").start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " start.");
                String result = exchanger.exchange("I am come from T-B");
                System.out.println(Thread.currentThread().getName() + " get value [" + result + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        },"[B]").start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " start.");
                String result = exchanger.exchange("I am come from T-C");
                System.out.println(Thread.currentThread().getName() + " get value [" + result + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        },"[C]").start();

    }
}
