package com.jdk.wangwenjun.chapter2.c04_observer.base;

/**
 * @author taobaibai
 * @create 2020-04-14 14:56
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Binary String: " + Integer.toBinaryString(subject.getState()));
    }
}
