package com.jdk.wangwenjun.chapter2.c17_workerThread;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 21:55
 */
public class WorkerThread extends Thread {
    private final Channel channel;
    private static final Random random = new Random(System.currentTimeMillis());

    public WorkerThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            channel.take().execute();
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
