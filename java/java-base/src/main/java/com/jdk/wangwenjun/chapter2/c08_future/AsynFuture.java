package com.jdk.wangwenjun.chapter2.c08_future;

/**
 * @author taobaibai
 * @create 2020-04-14 22:27
 */
public class AsynFuture<T> implements Future<T>{
    private volatile boolean done = false;
    private T result;

    public void done(T result){
        synchronized (this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!done){
                this.wait();
            }
        }
        return result;
    }
}
