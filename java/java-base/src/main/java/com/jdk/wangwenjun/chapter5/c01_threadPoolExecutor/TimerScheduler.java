package com.jdk.wangwenjun.chapter5.c01_threadPoolExecutor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * scheduler solution
 *   Timer/TimerTask
 *   SchedulerExecutorService
 *   crontab
 *   cron4j
 *   quartz
 *
 * @author taobaibai
 * @create 2020-04-19 21:53
 */
public class TimerScheduler {
    private static void sleepSeconds(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void timer(){
        Timer timer = new Timer();
        final TimerTask task = new TimerTask(){
            @Override
            public void run() {
                System.out.println("===========" + System.currentTimeMillis());
                sleepSeconds(10);
            }
        };
        timer.schedule(task, 1000, 20);
    }

    public static void main(String[] args) {
        timer();
    }
}
