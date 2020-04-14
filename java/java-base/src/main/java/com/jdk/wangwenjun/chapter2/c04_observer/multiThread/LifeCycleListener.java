package com.jdk.wangwenjun.chapter2.c04_observer.multiThread;

/**
 * @author taobaibai
 * @create 2020-04-14 15:12
 */
public interface LifeCycleListener {
    void onEvent(ObserverRunnable.RunnableEvent event);
}
