package com.jdk.wangwenjun.chapter4.c07_exchanger;

import java.util.concurrent.Exchanger;

/**
 * @author taobaibai
 * @create 2020-04-18 19:40
 */
public class ExchangerExample02 {

    public static void main(String[] args) {
        final Exchanger<Object> exchanger = new Exchanger<>();

        new Thread(()->{
            try {
                Object aObj = new Object();
                System.out.println(Thread.currentThread().getName() + " will send the object "+ aObj);
                Object result = exchanger.exchange(aObj);
                System.out.println(Thread.currentThread().getName() + " received the object [" + result + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        },"[A]").start();

        new Thread(()->{
            try {
                Object bObj = new Object();
                System.out.println(Thread.currentThread().getName() + " will send the object "+ bObj);
                Object result = exchanger.exchange(bObj);
                System.out.println(Thread.currentThread().getName() + " received the object [" + result + "]");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " end.");
        },"[B]").start();

    }
}
