package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 8:35
 */
public class FutureResult implements Result {
    private Result result;
    private boolean ready = false;

    public synchronized void setResult(Result result){
        this.result = result;
        this.ready = true;
        this.notifyAll();
    }

    @Override
    public synchronized Object getResultVal() {
        while (!ready){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.result.getResultVal();
    }
}
