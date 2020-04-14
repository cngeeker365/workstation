package com.jdk.highLevel.wangwenjun.concurrency.chapter1.BankWindow;

/**
 * @author taobaibai
 * @create 2020-04-09 23:19
 */
public class Bank {
    public static void main(String[] args) {
        final BankWindowRunnable ticketWin = new BankWindowRunnable();
        Thread winThread1 = new Thread(ticketWin, "Win-1");
        Thread winThread2 = new Thread(ticketWin, "Win-2");
        Thread winThread3 = new Thread(ticketWin, "Win-3");
        winThread1.start();
        winThread2.start();
        winThread3.start();
    }
}
