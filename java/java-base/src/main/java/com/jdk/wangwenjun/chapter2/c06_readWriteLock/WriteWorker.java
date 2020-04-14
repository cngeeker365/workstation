package com.jdk.wangwenjun.chapter2.c06_readWriteLock;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-14 19:45
 */
public class WriteWorker extends Thread{
    private static final Random random = new Random(System.currentTimeMillis());
    private final SharedData data;
    private final String filter;
    private int index = 0;

    public WriteWorker(SharedData data, String filter) {
        this.data = data;
        this.filter = filter;
    }

    @Override
    public void run() {
        try {
            while (true){
                char c = nextChar();
                data.write(c);
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private char nextChar(){
        char c = filter.charAt(index);
        index++;
        if(index>=filter.length()){
            index=0;
        }
        return c;
    }
}
