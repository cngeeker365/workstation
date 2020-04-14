package com.jdk.highLevel.wangwenjun.concurrency.chapter1;

/**
 * @author taobaibai
 * @create 2020-04-09 21:12
 */
public class DaemonThread2 {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            /**
             * 模拟内部线程，随外部线程而灭
             */
            Thread innerThread = new Thread(()->{
                while (true){
                    System.out.println("inner Thread ----> ");
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(1_000);
                System.out.println("T thread finish done.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
    }
}
