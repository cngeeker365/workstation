package com.jdk.wangwenjun.chapter1.c06_dataCollect;

/**
 * @author taobaibai
 * @create 2020-04-11 22:13
 */
public class CaptureRunnable implements Runnable {
    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed data capture at timestamp [%s] and successfully.\n", System.currentTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getResult(){
        return machineName+" finish.";
    }
}
