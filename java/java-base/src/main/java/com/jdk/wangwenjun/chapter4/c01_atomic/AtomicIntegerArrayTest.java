package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicIntegerArray;

import static org.junit.Assert.*;

/**
 * @author taobaibai
 * @create 2020-04-17 20:32
 */
public class AtomicIntegerArrayTest {

    @Test
    public void testCreate(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(10, array.length());
    }

    @Test
    public void testGet(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        assertEquals(0, array.get(5));
    }

    @Test
    public void testSet(){
        AtomicIntegerArray array = new AtomicIntegerArray(10);
        array.set(5, 5);
        assertNotEquals(0, array.get(5));
    }

    @Test
    public void testGetAndSet(){
        int[] origin = new int[10];
        origin[5]=5;
        AtomicIntegerArray array = new AtomicIntegerArray(origin);
        int v = array.getAndSet(5, 6);
        assertEquals(5, v);
        assertEquals(6, array.get(5));
    }
}
