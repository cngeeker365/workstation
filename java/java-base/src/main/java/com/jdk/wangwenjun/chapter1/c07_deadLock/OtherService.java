package com.jdk.wangwenjun.chapter1.c07_deadLock;

/**
 * @author taobaibai
 * @create 2020-04-12 17:05
 */
public class OtherService {
    private final Object lock = new Object();
    private DeadLock deadLock;

    public void s1() {
        synchronized (lock){
            System.out.println("s1============");
        }
    }
    public void s2() {
        synchronized (lock){
            System.out.println("s2============");
            deadLock.m2();
        }
    }

    public void setDeadLock(DeadLock deadLock) {
        this.deadLock = deadLock;
    }
}
