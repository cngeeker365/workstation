package com.jdk.wangwenjun.chapter4.c01_atomic;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertEquals;

/**
 * @author taobaibai
 * @create 2020-04-17 16:36
 */
public class AtomicLongTest {
    @Test
    public void testCreate(){
        /**
         * 源码中增加了 判断 JVM 是否支持 long 的无锁CAS
         */
        AtomicLong l = new AtomicLong(100L);
        assertEquals(100L, l.get());
    }
}
