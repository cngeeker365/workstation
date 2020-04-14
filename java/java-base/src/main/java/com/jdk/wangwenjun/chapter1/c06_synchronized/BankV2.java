package com.jdk.wangwenjun.chapter1.c06_synchronized;

/**
 * @author taobaibai
 * @create 2020-04-09 23:19
 */
public class BankV2 {
    public static void main(String[] args) {
        final BankWindowRunnableV2 ticketWin = new BankWindowRunnableV2();
        Thread winThread1 = new Thread(ticketWin, "Win-1");
        Thread winThread2 = new Thread(ticketWin, "Win-2");
        Thread winThread3 = new Thread(ticketWin, "Win-3");
        winThread1.start();
        winThread2.start();
        winThread3.start();
    }
}
