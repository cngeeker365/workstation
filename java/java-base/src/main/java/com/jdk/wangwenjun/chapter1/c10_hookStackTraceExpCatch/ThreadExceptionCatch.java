package com.jdk.wangwenjun.chapter1.c10_hookAndThreadExceptionCatch;

/**
 * @author taobaibai
 * @create 2020-04-12 22:09
 */
public class ThreadExceptionCatch {
    private final static int A = 10;
    private final static int B = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(5_000);
                int result = A/B;
                System.out.println(result);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1");

        //注入，并获取异常
        t1.setUncaughtExceptionHandler((thread, e)->{
            System.out.println(e);
            System.out.println(thread);
        });
        t1.start();
    }
}
