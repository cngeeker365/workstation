package com.jdk.wangwenjun.chapter4.c13_phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-19 14:12
 */
public class PhaserExample04 {
    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        final Phaser phaser = new Phaser(1);

        System.out.println(phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase());
        phaser.arriveAndAwaitAdvance();
        System.out.println(phaser.getPhase());

        System.out.println(phaser.getRegisteredParties());
        phaser.register();
        System.out.println(phaser.getRegisteredParties());
        phaser.register();
        System.out.println(phaser.getRegisteredParties());
        phaser.register();
        System.out.println(phaser.getRegisteredParties());

        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());

        phaser.bulkRegister(10);
        System.out.println(phaser.getRegisteredParties());
        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());
        new Thread(phaser::arriveAndAwaitAdvance).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(phaser.getRegisteredParties());
        System.out.println(phaser.getArrivedParties());
        System.out.println(phaser.getUnarrivedParties());

        final Phaser phaser1 = new Phaser(5){
            @Override
            protected boolean onAdvance(int phase, int registeredParties) {
                return true;
            }
        };
        new OnAdvanceTask("Alex", phaser1).start();
        new OnAdvanceTask("Jack", phaser1).start();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(phaser.getUnarrivedParties());
        System.out.println(phaser.getArrivedParties());
    }

    static class OnAdvanceTask extends Thread{
        private final Phaser phaser;

        public OnAdvanceTask(String name, Phaser phaser) {
            super(name);
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                System.out.println(getName() + " I am start and the phase="+phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
                System.out.println(getName() + " I am end.");

                TimeUnit.SECONDS.sleep(2);

                if(getName().startsWith("A")){
                    System.out.println(getName() + " I am start and the phase="+phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                    System.out.println(getName() + " I am end.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
