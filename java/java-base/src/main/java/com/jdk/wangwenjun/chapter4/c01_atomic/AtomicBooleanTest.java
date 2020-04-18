package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author taobaibai
 * @create 2020-04-17 16:14
 */
public class AtomicBooleanTest {
    @Test
    public void testCreateWithoutArgs(){
        AtomicBoolean bool = new AtomicBoolean();
        assertFalse(bool.get());
    }

    @Test
    public void testCreateWithArgs(){
        AtomicBoolean bool = new AtomicBoolean(true);
        assertTrue(bool.get());
    }

    @Test
    public void testGetAndSet(){
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean result = bool.getAndSet(false);
        assertTrue(result);
        assertFalse(bool.get());
    }

    @Test
    public void testCompareAndSet(){
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean result = bool.compareAndSet(true, false);
        assertTrue(result);
        assertFalse(bool.get());
    }

    @Test
    public void testCompareAndSetFailed(){
        AtomicBoolean bool = new AtomicBoolean(true);
        boolean result = bool.compareAndSet(false, true);
        assertFalse(result);
        assertTrue(bool.get());
    }
}
