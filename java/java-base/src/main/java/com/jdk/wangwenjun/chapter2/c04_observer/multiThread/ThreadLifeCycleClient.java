package com.jdk.wangwenjun.chapter2.c04_observer.multiThread;

import java.util.Arrays;

/**
 * @author taobaibai
 * @create 2020-04-14 15:24
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().concurrentQuery(Arrays.asList("1","2"));
    }
}
