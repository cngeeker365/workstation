package com.jdk.wangwenjun.chapter2.c09_guardedSuspension;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 9:59
 */
public class ServerThread extends Thread {
    private final RequestQueue queue;
    private final Random random;
    private volatile boolean closed = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!closed){
            Request request = queue.getRequest();
            if(null == request){
                System.out.println("Received the empty request.");
                continue;
            }
            System.out.println("Server --> " + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (Exception e) {
                return;
            }
        }
    }

    public void close(){
        this.closed = true;
        this.interrupt();
    }
}
