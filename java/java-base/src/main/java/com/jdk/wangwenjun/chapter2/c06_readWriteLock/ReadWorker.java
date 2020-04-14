package com.jdk.wangwenjun.chapter2.c06_readWriteLock;

/**
 * @author taobaibai
 * @create 2020-04-14 19:50
 */
public class ReadWorker extends Thread {
    private final SharedData data;

    public ReadWorker(SharedData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while(true){
                char[] readBuf = data.read();
                System.out.println(Thread.currentThread().getName() + " reads : " + String.valueOf(readBuf));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
