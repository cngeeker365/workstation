package com.jdk.wangwenjun.chapter5.c02_scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzScheduler {
    private static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class SimpleJob implements Job {
        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
            System.out.println("=============="+System.currentTimeMillis());
            sleep(5);
        }
    }

    public static void quartZ() throws SchedulerException {
        JobDetail job = newJob(SimpleJob.class).withIdentity("Job1", "Group1").build();
        Trigger trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule("0/5 * * * * ?")).build();
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(job, trigger);
    }

    public static void main(String[] args) throws SchedulerException {
        quartZ();
    }
}
