package com.jdk.wangwenjun.chapter4.c02_casTryLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author taobaibai
 * @create 2020-04-17 15:57
 */
public class CompareAndSetLock {
    private final AtomicInteger value = new AtomicInteger(0);
    private Thread lockedThread;

    //立即失败锁
    public void tryLock() throws GetLockException{
        boolean success = value.compareAndSet(0, 1);
        if(!success){
            throw new GetLockException("Failed to Get the Lock.");
        }else {
            lockedThread = Thread.currentThread();
        }
    }

    public void unlock(){
        if(0==value.get()){
            return;
        }
        if(lockedThread==Thread.currentThread() ) {
            boolean success = value.compareAndSet(1, 0);
        }
    }
}
