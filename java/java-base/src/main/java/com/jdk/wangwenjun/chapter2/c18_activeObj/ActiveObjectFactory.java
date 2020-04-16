package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 9:06
 */
public final class ActiveObjectFactory {
    private ActiveObjectFactory(){
    }

    public static ActiveObject createActiveObject(){
        Servant servant = new Servant();
        ActivationQueue queue = new ActivationQueue();
        SchedulerThread scheduler = new SchedulerThread(queue);
        ActiveObjectProxy proxy = new ActiveObjectProxy(scheduler, servant);
        scheduler.start();
        return proxy;
    }
}
