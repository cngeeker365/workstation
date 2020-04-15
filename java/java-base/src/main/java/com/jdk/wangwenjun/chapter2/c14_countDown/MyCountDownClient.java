package com.jdk.wangwenjun.chapter2.c14_countDown;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author taobaibai
 * @create 2020-04-15 16:28
 */
public class MyCountDownClient {
    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final MyCountDown latch = new MyCountDown(5);
        System.out.println("准备多线程处理任务.");
        //the first phase.

        IntStream.rangeClosed(1,5).forEach(i->{
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + " is working.");
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                latch.down();
            }, String.valueOf(i)).start();
        });

        latch.await();
        //The second phase.
        System.out.println("多线程任务全部结束，准备第二阶段任务");
        System.out.println(".................................");
        System.out.println("FINISH");
    }
}
