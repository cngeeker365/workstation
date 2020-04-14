package com.jdk.wangwenjun.chapter2.c02_waitSet;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-14 10:30
 */
public class WaitSet {
    private static final Object LOCK = new Object();

    /**
     * 1. 所有对象都有一个wait set，用来存放调用了该对象 wait 方法之后进入 block 状态的线程
     * 2. 线程被 notify 之后，不一定立即得到执行
     * 3. 线程从 wait set 中被唤醒的顺序不一定是 FIFO，具体方式不明
     * 4. 线程被唤醒后，必须重新获取锁，且会恢复执行地址，继续运行
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
//        waitSetTest();
        new Thread(()->work()).start();
        Thread.sleep(1000);
        synchronized (LOCK){
            LOCK.notify();
        }
    }

    public static void waitSetTest() throws InterruptedException {
        IntStream.rangeClosed(1,10).forEach(i->{
            new Thread(()->{
                synchronized (LOCK){
                    try {
                        Optional.of(Thread.currentThread().getName()+" will come to wait set.").ifPresent(System.out::println);
                        LOCK.wait();
                        Optional.of(Thread.currentThread().getName()+" will leave to wait set.").ifPresent(System.out::println);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },String.valueOf(i)).start();
        });

        Thread.sleep(3000);

        IntStream.rangeClosed(1,10).forEach(i->{
            synchronized (LOCK){
                LOCK.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void work(){
        synchronized (LOCK){
            System.out.println("Begin...");
            try {
                System.out.println("Thread will coming.");
                LOCK.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread will out.");
        }
    }
}
