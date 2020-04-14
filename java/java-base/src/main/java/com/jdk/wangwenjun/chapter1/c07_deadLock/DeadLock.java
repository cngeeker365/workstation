package com.jdk.wangwenjun.chapter1.c07_deadLock;

/**
 * @author taobaibai
 * @create 2020-04-12 17:04
 */
public class DeadLock {
    private final Object lock = new Object();
    private OtherService otherService = new OtherService();

    private DeadLock(OtherService otherService){
        this.otherService = otherService;
    }

    public void m1(){
        synchronized (lock){
            System.out.println("m1");
            otherService.s1();
        }
    }

    public void m2(){
        synchronized (lock){
            System.out.println("m2");
        }
    }

    public static void main(String[] args) {
        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);
        new Thread(()->{
            while (true){
                deadLock.m1();
            }
        }).start();
        new Thread(()->{
            while (true){
                otherService.s2();
            }
        }).start();
    }
}
