package com.jdk.wangwenjun.chapter4.c08_semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 20:14
 */
public class SemaphoreExample01 {
    public static void main(String[] args) {
        final SemaphoreLock lock = new SemaphoreLock();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " is Running.");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the SemaphoreLock.");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " release the SemaphoreLock.");
        }).start();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName() + " is Running.");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " get the SemaphoreLock.");
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + " release the SemaphoreLock.");
        }).start();
    }

    static class SemaphoreLock{
        private final Semaphore semaphore = new Semaphore(1);

        public void lock() throws InterruptedException{
            semaphore.acquire();
        }

        public void unlock(){
            semaphore.release();
        }
    }
}
