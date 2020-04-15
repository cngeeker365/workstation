package com.jdk.wangwenjun.chapter2.c10_threadLocal;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 11:14
 */
public class ThreadLocalSimulatorTest {

    private final static ThreadLocalSimulator<String> threadLocal = new ThreadLocalSimulator<String>(){
        @Override
        public String initialValue() {
            return "No Value";
        }
    };

    private final static Random random = new Random(System.currentTimeMillis());
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            threadLocal.set("Thread--T1");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(()->{
            threadLocal.set("Thread--T2");
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("============================================================");
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
    }
}
