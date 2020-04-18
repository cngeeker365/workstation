package com.jdk.wangwenjun.chapter4.c05_countDownLatch;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @author taobaibai
 * @create 2020-04-18 14:31
 */
public class CountDownLatchExample02 {

    @Test
    public void test() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        new Thread(()->{
            try {
                System.out.println("Do some initial working.");
                Thread.sleep(1000);
                latch.await();
                System.out.println("Do other working...");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                System.out.println("Asyn prepare for some data.");
                Thread.sleep(2000);
                System.out.println("Data prepare done.");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                latch.countDown();
            }
        }).start();

        Thread.currentThread().join();
    }

}
