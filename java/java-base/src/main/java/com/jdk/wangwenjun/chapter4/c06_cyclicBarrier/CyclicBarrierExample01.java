package com.jdk.wangwenjun.chapter4.c06_cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 16:23
 */
public class CyclicBarrierExample01 {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("all work done.");
            }
        });
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(20);
                System.out.println("T1 finished.");
                cyclicBarrier.await();
                System.out.println("T1: the other thread finished too.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(10);
                System.out.println("T2 finished.");
                cyclicBarrier.await();
                System.out.println("T2: the other thread finished too.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

//        cyclicBarrier.await();
//        System.out.println("all Thread done.");
        while (true){
            System.out.println(cyclicBarrier.getNumberWaiting());
            System.out.println(cyclicBarrier.getParties());
            System.out.println(cyclicBarrier.isBroken());
            TimeUnit.MILLISECONDS.sleep(10);
        }
    }
}
