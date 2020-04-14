package com.jdk.wangwenjun.chapter2.c06_readWriteLock;

/**
 * @author taobaibai
 * @create 2020-04-14 19:53
 */
public class ReadWriteClient {
    public static void main(String[] args) {
        final SharedData sharedData = new SharedData(10);
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();
        new ReadWorker(sharedData).start();

        new WriteWorker(sharedData, "kfdjodijfoissldkjf").start();
        new WriteWorker(sharedData, "fwerdfsd34tvxcwewe").start();
    }
}
