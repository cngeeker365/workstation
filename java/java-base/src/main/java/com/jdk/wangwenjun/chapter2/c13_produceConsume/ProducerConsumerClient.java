package com.jdk.wangwenjun.chapter2.c13_produceConsume;

/**
 * @author taobaibai
 * @create 2020-04-15 16:08
 */
public class ProducerConsumerClient {
    public static void main(String[] args) {
        final MessageQueue msgQueue = new MessageQueue();
        new ProducerThread(msgQueue, 1).start();
        new ProducerThread(msgQueue, 2).start();
        new ProducerThread(msgQueue, 3).start();
        new ConsumerThread(msgQueue, 1).start();
        new ConsumerThread(msgQueue, 2).start();
    }
}
