package com.jdk.wangwenjun.chapter2.c13_produceConsume;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 16:01
 */
public class ConsumerThread extends Thread{
    private final MessageQueue msgQueue;
    private final static Random random = new Random(System.currentTimeMillis());

    public ConsumerThread(MessageQueue msgQueue, int seq) {
        super("CONSUMER["+seq+"]");
        this.msgQueue = msgQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message msg = msgQueue.take();
                System.out.println(Thread.currentThread().getName()+" take a message :"+msg.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
