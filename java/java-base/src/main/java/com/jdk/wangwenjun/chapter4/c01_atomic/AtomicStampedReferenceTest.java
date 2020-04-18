package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author taobaibai
 * @create 2020-04-17 20:15
 */
public class AtomicStampedReferenceTest {
    private static AtomicStampedReference<Integer> atomicRef = new AtomicStampedReference<>(100, 0);

    @Test
    public void testABA() throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                boolean success = atomicRef.compareAndSet(100, 101,atomicRef.getStamp(), atomicRef.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"-->"+success);
                success = atomicRef.compareAndSet(101, 100,atomicRef.getStamp(), atomicRef.getStamp()+1);
                System.out.println(Thread.currentThread().getName()+"-->"+success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(()->{
            try {
                int stamp = atomicRef.getStamp();
                System.out.println("Before sleep: stamp="+stamp);
                TimeUnit.SECONDS.sleep(2);
                boolean success = atomicRef.compareAndSet(100, 101, stamp, stamp+1);
                System.out.println(Thread.currentThread().getName()+"-->"+success);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
