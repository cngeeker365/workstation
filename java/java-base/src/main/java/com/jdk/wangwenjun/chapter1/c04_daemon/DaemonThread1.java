package com.jdk.highLevel.wangwenjun.concurrency.chapter1;

/**
 * @author taobaibai
 * @create 2020-04-09 17:44
 */
public class DaemonThread1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + "run...");
                Thread.sleep(100_000);
                System.out.println(Thread.currentThread().getName() + "dead...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }); //new

        t.setDaemon(true);
        //runnable -> running | ->dead | ->blocked
        t.start();

        Thread.sleep(5_000); //jdk1.7
        System.out.println(Thread.currentThread().getName());
    }
}
