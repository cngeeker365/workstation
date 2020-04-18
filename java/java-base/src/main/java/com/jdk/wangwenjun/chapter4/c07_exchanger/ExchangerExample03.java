package com.jdk.wangwenjun.chapter4.c07_exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author taobaibai
 * @create 2020-04-18 19:40
 */
public class ExchangerExample03 {

    public static void main(String[] args) {
        final Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(()->{
            try {
                AtomicReference<Integer> value = new AtomicReference<>(1);
                while (true){
                    value.set(exchanger.exchange(value.get()));
                    System.out.println(Thread.currentThread().getName()+" as Value : "+value.get());
                    TimeUnit.SECONDS.sleep(3);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"[A]").start();

        new Thread(()->{
            try {
                AtomicReference<Integer> value = new AtomicReference<>(2);
                while (true){
                    value.set(exchanger.exchange(value.get()));
                    System.out.println(Thread.currentThread().getName()+" as Value : "+value.get());
                    TimeUnit.SECONDS.sleep(2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"[B]").start();

    }
}
