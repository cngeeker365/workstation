package com.jdk.wangwenjun.chapter1.c09_myLockDefine;

import java.util.Collection;

/**
 * @author taobaibai
 * @create 2020-04-12 20:41
 */
public interface Lock {
    //自定义Exception
    public static class TimeOutException extends Exception{
        public TimeOutException(String message) {
            super(message);
        }
    }

    //允许终端的锁
    void lock() throws InterruptedException;

    void lock(long mills) throws InterruptedException, TimeOutException;

    void unlock();

    //阻塞线程
    Collection<Thread> getBlockedThreads();

    int getBlockedSize();

}
