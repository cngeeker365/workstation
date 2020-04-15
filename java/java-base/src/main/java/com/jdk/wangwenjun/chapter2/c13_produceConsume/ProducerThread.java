package com.jdk.wangwenjun.chapter2.c13_produceConsume;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author taobaibai
 * @create 2020-04-15 16:01
 */
public class ProducerThread extends Thread{
    private final MessageQueue msgQueue;
    private final static Random random = new Random(System.currentTimeMillis());
    private final static AtomicInteger counter = new AtomicInteger(0);

    public ProducerThread(MessageQueue msgQueue, int seq) {
        super("PRODUCER["+seq+"]");
        this.msgQueue = msgQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                Message msg = new Message("Message-"+counter.getAndIncrement());
                msgQueue.put(msg);
                System.out.println(Thread.currentThread().getName()+" put message :"+msg.getData());
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
