package com.jdk.wangwenjun.chapter2.c04_observer.base;

/**
 * @author taobaibai
 * @create 2020-04-14 14:56
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
