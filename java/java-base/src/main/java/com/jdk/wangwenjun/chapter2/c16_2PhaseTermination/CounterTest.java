package com.jdk.wangwenjun.chapter2.c16_2PhaseTermination;

/**
 * @author taobaibai
 * @create 2020-04-15 20:59
 */
public class CounterTest {
    public static void main(String[] args) throws InterruptedException {
        CounterIncrement counterIncrement = new CounterIncrement();
        counterIncrement.start();

        Thread.sleep(10_000);
        counterIncrement.close();
    }
}
