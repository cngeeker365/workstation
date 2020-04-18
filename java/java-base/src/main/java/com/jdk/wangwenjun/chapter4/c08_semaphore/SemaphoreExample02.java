package com.jdk.wangwenjun.chapter4.c08_semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 20:14
 */
public class SemaphoreExample02 {

    /**
     * connection pool
     * When get the available connection/policy
     * 1. waiting 1000ms if not get then throw exception
     * 2. blocking
     * 3. discard
     * 4. get then throw exception
     * 5. get -> register the callback -> call
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" in");
                try {
                    semaphore.acquire(2);
                    System.out.println(Thread.currentThread().getName()+" get the Semaphore.");
                    TimeUnit.SECONDS.sleep(5);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(2);
                }
                System.out.println(Thread.currentThread().getName()+" out");
            }).start();
        }

        while(true){
            System.out.println("AP->"+semaphore.availablePermits());
            System.out.println("QL->"+semaphore.getQueueLength());
            TimeUnit.SECONDS.sleep(1);
        }

    }

}
