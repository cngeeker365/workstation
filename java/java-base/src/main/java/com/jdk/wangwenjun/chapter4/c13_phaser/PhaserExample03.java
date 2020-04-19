package com.jdk.wangwenjun.chapter4.c13_phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-19 14:12
 */
public class PhaserExample03 {
    private final static Random random = new Random(System.currentTimeMillis());

    static class InjuredAthletes extends Athletes{
        public InjuredAthletes(int no, Phaser phaser) {
            super(no, phaser);
        }

        @Override
        public void run() {
            try {
                sport(super.phaser, "["+super.no+"] start running...", "["+super.no+"] end running...");
                sport(super.phaser, "["+super.no+"] start cycling...", "["+super.no+"] end cycling...");
                System.out.println("Ohh, Injured! Cannot jump! Cancel Jump!");
                super.phaser.arriveAndDeregister(); //取消后续比赛
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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
                sport(phaser, "["+no+"] start running...", "["+no+"] end running...");
                sport(phaser, "["+no+"] start cycling...", "["+no+"] end cycling...");
                sport(phaser, "["+no+"] start jumping...", "["+no+"] end jumping...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public static void sport(Phaser phaser, String x, String x2) throws InterruptedException {
            System.out.println(x);
            TimeUnit.SECONDS.sleep(random.nextInt(5));
            System.out.println(x2);
            phaser.arriveAndAwaitAdvance();
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
        for (int i = 1; i < 5; i++) {
            new Athletes(i, phaser).start();
        }
        new InjuredAthletes(6, phaser).start();
    }
}
