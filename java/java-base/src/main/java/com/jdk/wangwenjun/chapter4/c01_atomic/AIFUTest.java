package com.jdk.wangwenjun.chapter4.c01_atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @author taobaibai
 * @create 2020-04-17 21:31
 */
public class AIFUTest {
    private volatile int i;
    private AtomicInteger j = new AtomicInteger();

    private AtomicIntegerFieldUpdater<AIFUTest> updater = AtomicIntegerFieldUpdater.newUpdater(AIFUTest.class, "i");

    public void update(int newVal){
        updater.compareAndSet(this, i, newVal);
    }

    public int get(){
        return i;
    }

    public static void main(String[] args) {
        AIFUTest test = new AIFUTest();
        test.update(10);
        System.out.println(test.get());
    }
}
