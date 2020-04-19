package com.jdk.wangwenjun.chapter4.c13_phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-19 14:12
 */
public class PhaserExample02 {
    private final static Random random = new Random(System.currentTimeMillis());

    static class Athletes extends Thread{
        private final int no;
        private final Phaser phaser;

        public Athletes(int no, Phaser phaser) {
            this.no = no;
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println("The Atheltes ["+no+"] start running...");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println("The Atheltes ["+no+"] end running...");
                System.out.println("getPhase()=>" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

                System.out.println("The Atheltes ["+no+"] start cycling...");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println("The Atheltes ["+no+"] end cycling...");
                System.out.println("getPhase()=>" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();

                System.out.println("The Atheltes ["+no+"] start jumping...");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println("The Atheltes ["+no+"] end jumping...");
                System.out.println("getPhase()=>" + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 铁人三项：
     *      【1】跑步
     *      【2】骑车
     *      【3】跳远
     * @param args
     */
    public static void main(String[] args) {
        final Phaser phaser = new Phaser(5);
        for (int i = 1; i < 6; i++) {
            new Athletes(i, phaser).start();
        }
    }
}
