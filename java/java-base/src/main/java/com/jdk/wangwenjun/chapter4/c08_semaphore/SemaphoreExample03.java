package com.jdk.wangwenjun.chapter4.c08_semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 20:14
 */
public class SemaphoreExample03 {

    /**
     * API:
     *      acquire(int permits)
     *      release(int permits)
     *      getQueueLength()
     *      availablePermits()
     *      acquireUninterruptibly()
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                semaphore.acquire(1);
                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release(1);
            }
            System.out.println("T1 finished");
        });
        t1.start();

        TimeUnit.MILLISECONDS.sleep(50);

        Thread t2 = new Thread(() -> {
            try {
//                semaphore.acquire(1);
                semaphore.acquireUninterruptibly();
//                TimeUnit.SECONDS.sleep(5);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release(1);
            }
            System.out.println("T2 finished.");
        });
        t2.start();

        TimeUnit.MILLISECONDS.sleep(50);
        t2.interrupt();
    }
}
