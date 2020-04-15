package com.jdk.wangwenjun.chapter2.c09_guardedSuspension;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 9:56
 */
public class ClientThread extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private final String sendValue;

    public ClientThread(RequestQueue queue, String sendValue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
        this.sendValue = sendValue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Client --> request " + sendValue);
            queue.putRequest(new Request(sendValue));
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
