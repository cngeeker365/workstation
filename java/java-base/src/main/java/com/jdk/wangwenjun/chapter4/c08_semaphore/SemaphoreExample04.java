package com.jdk.wangwenjun.chapter4.c08_semaphore;

import java.util.Collection;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-18 20:14
 */
public class SemaphoreExample04 {

    public static void main(String[] args) throws InterruptedException {
        final MySemaphore semaphore = new MySemaphore(5);

        Thread t1 = new Thread(() -> {
            try {
                //获取全部许可证
                semaphore.drainPermits();
                System.out.println(semaphore.availablePermits());
                TimeUnit.SECONDS.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release(5);
            }
            System.out.println("T1 finished");
        }, "T1");
        t1.start();

        TimeUnit.SECONDS.sleep(1);

        Thread t2 = new Thread(() -> {
            try {
                semaphore.acquire(1);
                System.out.println(semaphore.availablePermits());
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                semaphore.release(1);
            }
            System.out.println("T2 finished.");
        }, "T2");
        t2.start();

        Thread t3 = new Thread(() -> {
                boolean success = semaphore.tryAcquire(1);
                System.out.println(success?"Successful":"Failure");
                if(success){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    semaphore.release(1);
                }
            System.out.println("T3 finished.");
        }, "T3");
        t3.start();

        TimeUnit.SECONDS.sleep(1);
        System.out.println(semaphore.hasQueuedThreads());
        Collection<Thread> waitingThreads = semaphore.getWaitingThreads();
        for(Thread t : waitingThreads){
            System.out.println(t.getName());
        }

    }

    static class MySemaphore extends Semaphore{
        public MySemaphore(int permits) {
            super(permits);
        }

        public MySemaphore(int permits, boolean fair) {
            super(permits, fair);
        }

        public Collection<Thread> getWaitingThreads(){
            return super.getQueuedThreads();
        }
    }
}
