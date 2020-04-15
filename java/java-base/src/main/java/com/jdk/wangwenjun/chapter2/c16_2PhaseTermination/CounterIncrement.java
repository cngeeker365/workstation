package com.jdk.wangwenjun.chapter2.c16_2PhaseTermination;

import java.util.Random;

/**
 * @author taobaibai
 * @create 2020-04-15 20:54
 */
public class CounterIncrement extends Thread{
    private volatile boolean terminated = false;
    private int counter = 0;
    private Random random = new Random(System.currentTimeMillis());
    @Override
    public void run() {
        try {
            while (!terminated){
                System.out.println(Thread.currentThread().getName()+"\t"+(counter++));
                Thread.sleep(random.nextInt(1000));
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }finally {
            this.clean();
        }
    }

    private void clean() {
        System.out.println("Do Some Clean Work For The Second Phase. Current Counter: "+counter);
    }

    public void close(){
        this.terminated = true;
        this.interrupt();
    }
}
