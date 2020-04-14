package com.jdk.wangwenjun.chapter1.c09_myLockDefine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * @author taobaibai
 * @create 2020-04-12 20:44
 */
public class BooleanBlock implements Lock {
    //The initVal is true indicated the lock have been got.
    //The initVal is false indicated the lock is free for other threads to get.
    private boolean initVal;

    private Collection<Thread> blockedThreadCollection = new ArrayList<>();

    //记录获取锁的线程，谁加锁，谁释放
    private Thread currentThread;

    public BooleanBlock() {
        this.initVal = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (initVal){
            blockedThreadCollection.add(Thread.currentThread());
            this.wait();
        }
        this.initVal = true;
        blockedThreadCollection.remove(Thread.currentThread());
        this.currentThread = Thread.currentThread();
    }

    @Override
    public synchronized void lock(long mills) throws InterruptedException, TimeOutException {
        if(mills<=0){
            lock();
            return;
        }
        long hasRemaining = mills;
        long endTime = System.currentTimeMillis() + mills;
        while (initVal){
            if(hasRemaining<=0){
                throw new TimeOutException("Time Out!");
            }
            blockedThreadCollection.add(Thread.currentThread());
            this.wait(mills);
            hasRemaining = endTime-System.currentTimeMillis();
        }
        this.initVal=true;
        this.currentThread = Thread.currentThread();
        blockedThreadCollection.remove(Thread.currentThread());
    }

    @Override
    public synchronized void unlock() {
        //谁加锁，谁释放
        if(Thread.currentThread()==currentThread) {
            this.initVal = false;
            Optional.of(Thread.currentThread() + " release the lock monitor.").ifPresent(System.out::println);
            this.notifyAll();
        }
    }

    @Override
    public Collection<Thread> getBlockedThreads() {
        return Collections.unmodifiableCollection(blockedThreadCollection);
    }

    @Override
    public int getBlockedSize() {
        return blockedThreadCollection.size();
    }
}
