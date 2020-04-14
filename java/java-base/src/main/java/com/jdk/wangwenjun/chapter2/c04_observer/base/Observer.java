package com.jdk.wangwenjun.chapter2.c04_observer.base;

/**
 * @author taobaibai
 * @create 2020-04-14 14:50
 */
public abstract class Observer {
    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public abstract void update();
}
