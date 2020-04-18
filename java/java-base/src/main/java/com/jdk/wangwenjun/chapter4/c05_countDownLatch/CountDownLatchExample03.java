package com.jdk.wangwenjun.chapter4.c05_countDownLatch;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 14:40
 */
public class CountDownLatchExample03 {
    @Test
    public void testCreate() throws Exception {
        //参数 ≥ 0
        final CountDownLatch latch = new CountDownLatch(0);
        latch.await();
        System.out.println("==================================");
    }

    @Test
    public void testAwait() throws Exception {
        final CountDownLatch latch = new CountDownLatch(1);
        final Thread mainThread = Thread.currentThread();

        new Thread(()->{
            try {
                Thread.sleep(10000);
                System.out.println("******************************");
            } catch (Exception e) {
                e.printStackTrace();
            }
            latch.countDown();
//            mainThread.interrupt();
        }).start();

//        latch.await();
        latch.await(1000, TimeUnit.MILLISECONDS);
        System.out.println("===================================");
        //countDown 结束后，再 countDown 没有意义
        latch.countDown();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
