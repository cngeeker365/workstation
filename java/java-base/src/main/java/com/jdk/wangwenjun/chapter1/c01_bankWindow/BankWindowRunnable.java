package com.jdk.highLevel.wangwenjun.concurrency.chapter1.BankWindow;

/**
 * @author taobaibai
 * @create 2020-04-09 23:17
 */
public class BankWindowRunnable implements Runnable {
    private int index = 0;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread().getName()+"==>"+(index++));
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
