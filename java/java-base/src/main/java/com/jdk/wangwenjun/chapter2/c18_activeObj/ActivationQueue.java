package com.jdk.wangwenjun.chapter2.c18_activeObj;

import java.util.LinkedList;

/**
 * @author taobaibai
 * @create 2020-04-16 8:50
 */
public class ActivationQueue {
    private final static int MAX_METHOD_REQUEST_QUEUE_SIZE = 100;
    private final LinkedList<MethodRequest> methodQueue;

    public ActivationQueue() {
        this.methodQueue = new LinkedList<>();
    }

    public synchronized void put(MethodRequest request){
        while (methodQueue.size()>=MAX_METHOD_REQUEST_QUEUE_SIZE){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.methodQueue.addLast(request);
        this.notifyAll();
    }

    public synchronized MethodRequest take(){
        while (methodQueue.isEmpty()){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        MethodRequest methodRequest = methodQueue.removeFirst();
        this.notifyAll();
        return methodRequest;
    }
}
