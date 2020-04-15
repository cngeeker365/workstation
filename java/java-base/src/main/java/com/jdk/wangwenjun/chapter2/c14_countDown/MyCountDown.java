package com.jdk.wangwenjun.chapter2.c14_countDown;

/**
 * @author taobaibai
 * @create 2020-04-15 16:25
 */
public class MyCountDown {
    private final int total;
    private int counter = 0;

    public MyCountDown(int total) {
        this.total = total;
    }

    public void down(){
        synchronized (this){
            this.counter++;
            this.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (this){
            while (counter!=total){
                this.wait();
            }
        }
    }
}
