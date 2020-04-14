package com.jdk.wangwenjun.chapter2.c08_future;

/**
 * @author taobaibai
 * @create 2020-04-14 22:25
 */
public interface FutureTask<T> {
    //call实际做事
    T call();
}
