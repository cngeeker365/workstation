package com.jdk.wangwenjun.chapter1.c06_synchronized;

/**
 * @author taobaibai
 * @create 2020-04-12 21:07
 */
public class SynchronizedProblem {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            SynchronizedProblem.run();
        }, "t1");
        t1.start();
        Thread.sleep(1000);
        Thread t2 = new Thread(()->{
            SynchronizedProblem.run();
        }, "t2");
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }
    private synchronized static void run(){
        System.out.println(Thread.currentThread().getName());
        while (true){

        }
    }
}
