package com.jdk.wangwenjun.chapter2.c17_workerThread;

import java.util.Arrays;

/**
 * @author taobaibai
 * @create 2020-04-15 21:53
 */
public class Channel {
    private final static int MAX_REQUEST = 100;
    private final Request[] requestsQueue;
    private int head;
    private int tail;
    private int count;
    private final WorkerThread[] workerPool;

    public Channel(int workers) {
        this.requestsQueue = new Request[MAX_REQUEST];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
        this.workerPool = new WorkerThread[workers];
        this.init();
    }

    private void init() {
        for (int i = 0; i < workerPool.length; i++) {
            workerPool[i] = new WorkerThread("Worker-"+i, this);
        }
    }

    /**
     * push switch to start all of worker to work.
     */
    public void startWorker(){
        Arrays.asList(workerPool).forEach(WorkerThread::start);
    }

    public synchronized void put(Request request){
        while (count >= requestsQueue.length){
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        this.requestsQueue[tail] = request;
        this.tail = (tail+1)%requestsQueue.length;
        this.count++;
        this.notifyAll();
    }

    public synchronized Request take(){
        while (count<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = this.requestsQueue[head];
        this.head = (this.head+1)%this.requestsQueue.length;
        this.count--;
        this.notifyAll();
        return request;
    }
}
