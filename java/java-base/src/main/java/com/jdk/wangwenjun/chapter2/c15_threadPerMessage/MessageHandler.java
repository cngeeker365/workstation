package com.jdk.wangwenjun.chapter2.c15_threadPerMessage;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author taobaibai
 * @create 2020-04-15 16:36
 */
public class MessageHandler {
    private static final Random random = new Random(System.currentTimeMillis());
    private final static Executor executor = Executors.newFixedThreadPool(5);
    public void request(Message msg){
        executor.execute(()->{
            String value = msg.getData();
            try {
                Thread.sleep(random.nextInt(1000));
                System.out.println("The msg will be handled by " + Thread.currentThread().getName()+"\t"+value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
//        new Thread(()->{
//            String value = msg.getData();
//            try {
//                Thread.sleep(random.nextInt(1000));
//                System.out.println("The msg will be handled by " + Thread.currentThread().getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }).start();
    }

    public void shutdown(){
        ( (ExecutorService) executor).shutdown();
    }
}
