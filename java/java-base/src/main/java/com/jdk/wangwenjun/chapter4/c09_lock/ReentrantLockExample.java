package com.jdk.wangwenjun.chapter4.c09_lock;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taobaibai
 * @create 2020-04-18 21:35
 */
public class ReentrantLockExample {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void needLock(){
        try{
            lock.lock();
            Optional.of("The thread-"+Thread.currentThread().getName()+" get lock and will do working.").ifPresent(System.out::println);
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void needLockBySync(){
        synchronized (ReentrantLockExample.class){
            try{
                TimeUnit.SECONDS.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void testUnInterruptibly(){
        try{
            lock.lock();
            Optional.of("The thread-"+Thread.currentThread().getName()+" get lock and will do working.").ifPresent(System.out::println);
            while (true){

            }
        } finally{
            lock.unlock();
        }
    }

    public static void testInterruptibly(){
        try{
            lock.lockInterruptibly();
            Optional.of("The thread-"+Thread.currentThread().getName()+" get lock and will do working.").ifPresent(System.out::println);
            while (true){

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
            lock.unlock();
        }
    }

    public static void testTryLock(){
        if(lock.tryLock()){
            try{
                Optional.of("The thread-"+Thread.currentThread().getName()+" get lock and will do working.").ifPresent(System.out::println);
                while (true){

                }
            } finally{
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        IntStream.range(0,2).forEach(i->new Thread(()->needLock(), String.valueOf(i)).start());

//        Thread t1 = new Thread(()-> testUnInterruptibly());
//        t1.start();
//        TimeUnit.SECONDS.sleep(1);
//        Thread t2 = new Thread(()-> testInterruptibly());
//        t2.start();
//        TimeUnit.SECONDS.sleep(1);
//        t2.interrupt();
//        System.out.println("================================");

//        Thread t1 = new Thread(()-> testTryLock());
//        t1.start();
//        TimeUnit.SECONDS.sleep(1);
//        Thread t2 = new Thread(()-> testTryLock());
//        t2.start();

        Thread t1 = new Thread(()-> testUnInterruptibly());
        t1.start();
        TimeUnit.SECONDS.sleep(1);
        Thread t2 = new Thread(()-> testInterruptibly());
        t2.start();
        TimeUnit.SECONDS.sleep(1);
        Optional.of(lock.getQueueLength()).ifPresent(System.out::println);
        Optional.of(lock.hasQueuedThreads()).ifPresent(System.out::println);
        Optional.of(lock.hasQueuedThread(t1)).ifPresent(System.out::println);
        Optional.of(lock.hasQueuedThread(t2)).ifPresent(System.out::println);
        Optional.of(lock.getHoldCount()).ifPresent(System.out::println);
        Optional.of(lock.isLocked()).ifPresent(System.out::println);
    }
}
