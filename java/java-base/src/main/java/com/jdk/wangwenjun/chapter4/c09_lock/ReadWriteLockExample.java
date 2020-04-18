package com.jdk.wangwenjun.chapter4.c09_lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author taobaibai
 * @create 2020-04-18 22:25
 */
public class ReadWriteLockExample {
//    private final static ReentrantLock lock = new ReentrantLock(true);
    private final static ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
    private final static Lock readLock = lock.readLock();
    private final static Lock writeLock = lock.writeLock();
    private final static List<Long> data = new ArrayList<>();

    public static void write(){
        try{
//            lock.lock();
            writeLock.lock();
            data.add(System.currentTimeMillis());
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
//            lock.unlock();
            writeLock.unlock();
        }
    }

    public static void read(){
        try{
//            lock.lock();
            readLock.lock();
            data.forEach(System.out::println);
            System.out.println(Thread.currentThread().getName()+"====================================");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally{
//            lock.unlock();
            readLock.unlock();
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(ReadWriteLockExample::write);
        t1.start();
        Thread t2 = new Thread(ReadWriteLockExample::read);
        t2.start();
        Thread t3 = new Thread(ReadWriteLockExample::read);
        t3.start();
    }
}
