package com.jdk.wangwenjun.chapter2.c09_guardedSuspension;

/**
 * @author taobaibai
 * @create 2020-04-15 10:11
 */
public class SuspensionClient {
    public static void main(String[] args) throws InterruptedException {
        final RequestQueue queue = new RequestQueue();
        new ClientThread(queue, "Alex").start();
        ServerThread serverThread = new ServerThread(queue);
        serverThread.start();

        Thread.sleep(10_000);
        serverThread.close();


    }
}
