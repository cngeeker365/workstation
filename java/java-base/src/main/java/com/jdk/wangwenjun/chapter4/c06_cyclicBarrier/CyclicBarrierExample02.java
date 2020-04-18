package com.jdk.wangwenjun.chapter4.c06_cyclicBarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 17:32
 */
public class CyclicBarrierExample02 {
    public static void main(String[] args) throws Exception {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();


//        TimeUnit.MICROSECONDS.sleep(100);

        TimeUnit.SECONDS.sleep(4);
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());

        //reset == init == finish == broke
        cyclicBarrier.reset();

        TimeUnit.SECONDS.sleep(2);
        System.out.println(cyclicBarrier.getNumberWaiting());
        System.out.println(cyclicBarrier.getParties());
        System.out.println(cyclicBarrier.isBroken());
    }
}
