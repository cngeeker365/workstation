package com.jdk.wangwenjun.chapter2.c10_threadLocal;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟 ThreadLocal，始终以当前线程作为key值
 * @author taobaibai
 * @create 2020-04-15 11:11
 */
public class ThreadLocalSimulator<T> {
    private final Map<Thread, T> storage = new HashMap<>();

    public void set(T t){
        synchronized (this){
            Thread key = Thread.currentThread();
            storage.put(key, t);
        }
    }

    public T get(){
        synchronized (this){
            Thread key = Thread.currentThread();
            T value = storage.get(key);
            if(null == value){
                return initialValue();
            }
            return value;
        }
    }

    public T initialValue() {
        return null;
    }
}
