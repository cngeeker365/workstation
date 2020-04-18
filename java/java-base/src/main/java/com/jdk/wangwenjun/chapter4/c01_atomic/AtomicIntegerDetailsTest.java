package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-17 10:43
 */
public class AtomicIntegerDetailsTest {

    @Test
    public void testCreate(){
        AtomicInteger i = new AtomicInteger();
        System.out.println(i.get());

        i = new AtomicInteger(10);
        System.out.println(i.get());

        i.set(12);
        System.out.println(i.get());

        i.lazySet(15);

        boolean flag = i.compareAndSet(12, 20);
        System.out.println(i.get());
        System.out.println(flag);

        System.out.println("=================================");

        AtomicInteger getAndSet = new AtomicInteger(10);
        int result = getAndSet.getAndAdd(10);
        System.out.println(result);
        System.out.println(getAndSet.get());

        System.out.println("=================================");

        final AtomicInteger getAndSet2 = new AtomicInteger();
        IntStream.rangeClosed(0, 5).forEach(j->{
            new Thread(()->{
                for (int k = 0; k < 10; k++) {
                    int v = getAndSet2.addAndGet(1);
                    System.out.println(v);
                }
            }, "Thread["+j+"]").start();
        });
    }
}
