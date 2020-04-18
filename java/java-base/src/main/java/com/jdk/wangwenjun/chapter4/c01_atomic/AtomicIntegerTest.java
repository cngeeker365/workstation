package com.jdk.wangwenjun.chapter4.c01_automic;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author taobaibai
 * @create 2020-04-17 10:43
 */
public class AtomicIntegerTest {

    /**
     * volatile 特性:
     *  1. 保证内存可见性
     *  2. 内存屏障，即顺序性
     *  3. 不保证原子性
     */
    private static volatile int value = 0;
    private static Set<Integer> set = Collections.synchronizedSet(new LinkedHashSet<>());

    public static void main(String[] args) throws Exception {
//        testVolatile();
        testAutomicInteger();
    }

    public static void testVolatile() throws InterruptedException {
        Thread t1 = new Thread(()->{
            int x = 0;
            while (x<500){
                int tmp = value;
                System.out.println(Thread.currentThread().getName() + ":" + tmp);
                /**
                 * [1] get value from main memory
                 * [2] add 1 => x
                 * [3] assign the value to x
                 * [4] flush to main memory
                 */
                value+=1;
                x++;
            }
        });
        Thread t2 = new Thread(()->{
            int x = 0;
            while (x<500){
                int tmp = value;
                System.out.println(Thread.currentThread().getName() + ":" + tmp);
                value+=1;
                x++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    public static void testAutomicInteger() throws InterruptedException {
        final AtomicInteger val = new AtomicInteger();
        Thread t1 = new Thread(()->{
            int x = 0;
            while (x<500){
                int v = val.getAndIncrement();
                set.add(v);
                System.out.println(Thread.currentThread().getName() + ":" + v);
                x++;
            }
        });
        Thread t2 = new Thread(()->{
            int x = 0;
            while (x<500){
                int v = val.getAndIncrement();
                set.add(v);
                System.out.println(Thread.currentThread().getName() + ":" + v);
                x++;
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(set.size());
        System.out.println(set);
    }
}
