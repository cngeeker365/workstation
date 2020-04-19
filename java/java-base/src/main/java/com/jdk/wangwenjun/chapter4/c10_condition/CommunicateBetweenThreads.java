package com.jdk.wangwenjun.chapter4.c10_condition;

import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-19 10:42
 */
public class CommunicateBetweenThreads {
    private static int data = 0;
    private static boolean noUse = true;
    private final static Object MONITOR = new Object();

    private static void buildData(){
        synchronized (MONITOR){
            try {
                while (noUse){
                    MONITOR.wait();
                }
                data++;
                TimeUnit.SECONDS.sleep(1);
                System.out.println("P=> " + data);
                noUse=true;
                MONITOR.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void useData(){
        synchronized (MONITOR){
            try {
                while(!noUse){
                    MONITOR.wait();
                }
                TimeUnit.SECONDS.sleep(1);
                System.out.println("C=> " + data);
                noUse=false;
                MONITOR.notifyAll();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(()->{
            for(;;){
                buildData();
            }
        }).start();

        new Thread(()->{
            for(;;){
                useData();
            }
        }).start();
    }
}