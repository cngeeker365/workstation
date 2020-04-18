package com.jdk.wangwenjun.chapter4.c03_unsafe;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author taobaibai
 * @create 2020-04-17 21:58
 */
public class UnsafeTest {

    /**
     * Java is a safe programming language and prevents programmer from doing a lot of stupid mistakes,
     * most of which based on memory management.
     * But, there is a way to do such mistakes intentionally, using Unsafe class.
     */
    @Test
    public void testUnsafe(){
        //java.lang.SecurityException: Unsafe
        Unsafe unsafe = Unsafe.getUnsafe();
        System.out.println(unsafe);
    }


    @Test
    public void testReflect(){
        Unsafe unsafe = getUnsafe();
        System.out.println(unsafe);
    }

    /**
     * 通过反射方式可以获取到 Unsafe
     * @return
     */
    private static Unsafe getUnsafe(){
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }

    interface Counter{
        void increment();
        long getCounter();
    }
    static class CounterRunnable implements Runnable{
        private final Counter counter;
        private final int num;

        CounterRunnable(Counter counter, int num) {
            this.counter = counter;
            this.num = num;
        }

        @Override
        public void run() {
            for (int i = 0; i < num; i++) {
                counter.increment();
            }
        }
    }

    static class StupidCounter implements Counter{
        private long counter = 0;

        @Override
        public void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    static class SyncCounter implements Counter{
        private long counter = 0;

        @Override
        public synchronized void increment() {
            counter++;
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    static class LockCounter implements Counter{
        private long counter = 0;
        private final Lock lock = new ReentrantLock();
        @Override
        public void increment() {
            try {
                lock.lock();
                counter++;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }
    static class AtomicCounter implements Counter{
        private AtomicLong counter = new AtomicLong();
        @Override
        public void increment() {
            counter.incrementAndGet();
        }

        @Override
        public long getCounter() {
            return counter.get();
        }
    }
    static class CasCounter implements Counter{
        private volatile long counter = 0;
        private Unsafe unsafe;
        private long offset;

        CasCounter() throws NoSuchFieldException {
            unsafe = getUnsafe();
            offset = unsafe.objectFieldOffset(CasCounter.class.getDeclaredField("counter"));
        }

        @Override
        public void increment() {
            long current = counter;
            while (!unsafe.compareAndSwapLong(this, offset, current, current+1)){
                current = counter;
            }
        }

        @Override
        public long getCounter() {
            return counter;
        }
    }

    @Test
    public void testCounter() throws Exception {
        //定义线程池
        ExecutorService service = Executors.newFixedThreadPool(1000);
        /**
         * counter：竞争资源，Shared Data
         *  [StupidCounter]-------------------------------
         *      Counter result : 9978640    结果错误
         *      Time passed in ms : 137     速度可以
         *  [SyncCounter]---------------------------------
         *      Counter result : 10000000
         *      Time passed in ms : 384     速度慢，并行任务彻底串行化
         *  [LockCounter]---------------------------------
         *      Counter result : 10000000
         *      Time passed in ms : 294
         *  [AtomicCounter]-------------------------------
         *      Counter result : 10000000
         *      Time passed in ms : 336
         *  [CasCounter]----------------------------------
         *      Counter result : 10000000
         *      Time passed in ms : 960
         */
        Counter counter = new CasCounter();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            service.submit(new CounterRunnable(counter, 10000));
        }
        service.shutdown();
        service.awaitTermination(1, TimeUnit.HOURS);
        long end = System.currentTimeMillis();
        System.out.println("Counter result : "+counter.getCounter());
        System.out.println("Time passed in ms : "+(end-start));
    }
}
