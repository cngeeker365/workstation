package com.jdk.wangwenjun.chapter4.c05_countDownLatch;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 13:21
 */
public class CountDownLatchExample01 {
    private static Random random = new Random(System.currentTimeMillis());
    private static ExecutorService executor = Executors.newFixedThreadPool(2);
    private static final CountDownLatch latch = new CountDownLatch(10);

    @Test
    public void testNoCountDown() throws Exception {
         // [1] get data from db
        int[] data = query();
         // [2] process data
        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnable(data, i, null));
        }
         // [3] save or send to others
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
        System.out.println("all work done.");
    }

    @Test
    public void testCountDownLatch() throws Exception{
        // [1] get data from db
        int[] data = query();
        // [2] process data
        for (int i = 0; i < data.length; i++) {
            executor.execute(new SimpleRunnable(data, i, latch));
        }
        // [3] save or send to others
        latch.await();
        System.out.println("all work done.");
        executor.shutdown();
    }

    static class SimpleRunnable implements Runnable{
        private final int[] data;
        private final int index;
        private final CountDownLatch latch;

        public SimpleRunnable(int[] data, int index, CountDownLatch latch) {
            this.data = data;
            this.index = index;
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            int value = data[index];
            if(value %2 == 0){
                data[index] = value*2;
            }else {
                data[index] = value*10;
            }
            System.out.println(Thread.currentThread().getName()+" finished.");
            if(latch!=null){
                latch.countDown();
            }
        }
    }

    private static int[] query(){
        return new int[]{1,2,3,4,5,6,7,8,9,10};
    }
}
