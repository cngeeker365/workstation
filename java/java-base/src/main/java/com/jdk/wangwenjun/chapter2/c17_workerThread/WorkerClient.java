package com.jdk.wangwenjun.chapter2.c17_workerThread;

/**
 * @author taobaibai
 * @create 2020-04-15 22:15
 */
public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();

        new TransportThread("Alex", channel).start();
        new TransportThread("Jack", channel).start();
        new TransportThread("William", channel).start();

    }
}
