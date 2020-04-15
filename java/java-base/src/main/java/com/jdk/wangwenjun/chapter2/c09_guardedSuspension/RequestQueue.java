package com.jdk.wangwenjun.chapter2.c09_guardedSuspension;

import java.util.LinkedList;

/**
 * @author taobaibai
 * @create 2020-04-15 9:50
 */
public class RequestQueue {
    private final LinkedList<Request> queue = new LinkedList<>();

    public Request getRequest(){
        synchronized (queue){
            while (queue.size() <= 0){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    return null;
                }
            }
            return queue.removeFirst();
        }
    }

    public void putRequest(Request request){
        synchronized (queue){
            queue.addLast(request);
            queue.notifyAll();
        }
    }
}
