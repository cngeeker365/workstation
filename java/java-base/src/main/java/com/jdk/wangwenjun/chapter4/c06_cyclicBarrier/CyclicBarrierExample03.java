package com.jdk.wangwenjun.chapter4.c06_cyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 17:52
 */
public class CyclicBarrierExample03 {
    static class MyCountDownLatch extends CountDownLatch{
        private final Runnable runnable;
        public MyCountDownLatch(int count, Runnable runnable) {
            super(count);
            this.runnable = runnable;
        }

        @Override
        public void countDown() {
            super.countDown();
            if(getCount()==0){
                this.runnable.run();
            }
        }
    }

    public static void main(String[] args) {
        final MyCountDownLatch latch = new MyCountDownLatch(2, new Runnable(){
            @Override
            public void run() {
                System.out.println("all work done.");
            }
        });
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " finished.");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " finished.");
        }).start();;
    }
}
