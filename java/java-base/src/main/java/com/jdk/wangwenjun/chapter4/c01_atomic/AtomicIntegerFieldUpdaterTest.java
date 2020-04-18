package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author taobaibai
 * @create 2020-04-17 20:54
 */
public class AtomicIntegerFieldUpdaterTest {

    @Test
    public void test(){
        final AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        final TestMe me = new TestMe();

        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                final int MAX = 20;
                for (int j = 0; j < MAX; j++) {
                    int result = updater.getAndIncrement(me);
                    System.out.println(Thread.currentThread().getName()+" => "+result);
                }
            }).start();
        }
    }

    /**
     * 不能访问私有属性
     */
    @Test
    public void testFailedAccessPrivateProperty(){
        final AtomicIntegerFieldUpdater<TestMePrivate> updater = AtomicIntegerFieldUpdater.newUpdater(TestMePrivate.class, "i");
        final TestMePrivate me = new TestMePrivate();

        //报错：IllegalAccessException，不能访问私有属性
        updater.compareAndSet(me, 0, 1);
    }

    @Test
    public void testTargetObjectIsNull(){
        final AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i");
        updater.compareAndSet(null, 0, 1);
    }

    @Test
    public void testFieldNameInvalid(){
        final AtomicIntegerFieldUpdater<TestMe> updater = AtomicIntegerFieldUpdater.newUpdater(TestMe.class, "i1");
        final TestMe me = new TestMe();
        updater.compareAndSet(me, 0, 1);
    }

    @Test
    public void testFieldType(){
        //TestMe 中的属性 i 的类型为 int，不是String
        final AtomicReferenceFieldUpdater<TestMe, String> updater = AtomicReferenceFieldUpdater.newUpdater(TestMe.class, String.class, "i");
        final TestMe me = new TestMe();
        updater.compareAndSet(me, "0", "1");
    }

    @Test
    public void testFieldNotVolatile(){
        //java.lang.IllegalArgumentException: Must be volatile type
        //属性必须是 volatile 的才可以
        final AtomicReferenceFieldUpdater<TestMeNotVolatile, Integer> updater = AtomicReferenceFieldUpdater.newUpdater(TestMeNotVolatile.class, Integer.class, "i");
        final TestMeNotVolatile me = new TestMeNotVolatile();
        updater.compareAndSet(me, 0, 1);
    }

    static class TestMe{
        volatile int i;
    }

    static class TestMePrivate{
        private volatile int i;
    }

    static class TestMeNotVolatile{
        Integer i;
    }
}
