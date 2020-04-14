package com.jdk.wangwenjun.chapter2.c04_observer.base;

/**
 * @author taobaibai
 * @create 2020-04-14 14:50
 */
public class ObserverClient {
    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("=======================");
        subject.setState(10);
        System.out.println("=======================");
        subject.setState(15);
    }
}
