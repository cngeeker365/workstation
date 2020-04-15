package com.jdk.wangwenjun.chapter2.c13_produceConsume;

import java.util.LinkedList;

/**
 * @author taobaibai
 * @create 2020-04-15 15:33
 */
public class MessageQueue {
    private final LinkedList<Message> queue ;
    private final static int DEFAULT_MAX_LIMIT = 100;
    private final int limit;
    public MessageQueue() {
        this(DEFAULT_MAX_LIMIT);
    }
    public MessageQueue(final int limit){
        this.limit = limit;
        this.queue = new LinkedList<>();
    }

    public void put(Message msg) throws InterruptedException {
        synchronized (queue){
            while (queue.size()>limit){
                queue.wait();
            }
            queue.addLast(msg);
            queue.notifyAll();
        }
    }

    public Message take() throws InterruptedException {
        synchronized (queue){
            while (queue.isEmpty()){
                queue.wait();
            }
            Message msg = queue.removeFirst();
            queue.notifyAll();
            return msg;
        }
    }

    public int getMaxLimit(){
        return this.limit;
    }

    public int getMessageSize(){
        synchronized (queue){
            return queue.size();
        }
    }
}
