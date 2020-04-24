package com.jdk.wangwenjun.chapter6.c02_concurrencyCollection;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author taobaibai
 * @create 2020-04-22 11:02
 */
public class ArrayBlockingQueueExample {
    public <T> ArrayBlockingQueue<T> createQueue(int size){
        return new ArrayBlockingQueue<>(size);
    }
}
