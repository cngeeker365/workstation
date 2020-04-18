package com.jdk.wangwenjun.chapter4.c02_casTryLock;

import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-17 15:52
 */
public class AtomicIntegerDetailTest_2 {
    private final static CompareAndSetLock lock = new CompareAndSetLock();

    public static void main(String[] args) {
        IntStream.rangeClosed(0,5).forEach(i->{
//            new Thread(()-> doSomthingBySync()).start();
            new Thread(()-> doSomthingByCAS()).start();
        });
    }

    private static void doSomthingBySync() {
        synchronized (AtomicIntegerDetailTest_2.class){
            System.out.println(Thread.currentThread().getName() + " get the lock");
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void doSomthingByCAS() {
            try {
                lock.tryLock();
                System.out.println(Thread.currentThread().getName() + " get the lock");
                Thread.sleep(100_000);
            } catch (InterruptedException | GetLockException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
    }
}
