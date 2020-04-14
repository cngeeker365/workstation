package com.jdk.wangwenjun.chapter1.c06_dataCollect;

/**
 * @author taobaibai
 * @create 2020-04-11 22:17
 */
public class CaptureThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        long startTimestamp = System.currentTimeMillis();

        Thread t1 = new Thread(new CaptureRunnable("M1",10000L), "t1");
        Thread t2 = new Thread(new CaptureRunnable("M1",10000L), "t2");
        Thread t3 = new Thread(new CaptureRunnable("M1",10000L), "t3");

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        long endTimestamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is : %s, end timestamp is : %s\n", startTimestamp, endTimestamp );
    }
}
