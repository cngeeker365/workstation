package com.jdk.wangwenjun.chapter2.c08_future;

/**
 * @author taobaibai
 * @create 2020-04-14 22:24
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
