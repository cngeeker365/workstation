package com.jdk.wangwenjun.chapter2.c06_readWriteLock;

/**
 * @author taobaibai
 * @create 2020-04-14 19:26
 */
public class ReadWriteLock {
    private int readingReaders = 0;
    private int waitingReaders = 0;
    private int writingWriters = 0;
    private int waitingWriters = 0;
    private boolean preferWriter = true;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWriter) {
        this.preferWriter = preferWriter;
    }

    public synchronized void readLock(){
        this.waitingReaders++;
        try {
            while (writingWriters>0 || (preferWriter && waitingWriters>0)){
                this.wait();
            }
            readingReaders++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.waitingReaders--;
        }
    }

    public synchronized void readUnlock(){
        this.readingReaders--;
        this.notifyAll();
    }

    public synchronized void writeLock(){
        this.waitingWriters++;
        try {
            while (readingReaders>0 || writingWriters>0){
                this.wait();
            }
            this.writingWriters++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.waitingWriters--;
        }
    }

    public synchronized void writeUnlock(){
        this.writingWriters--;
        this.notifyAll();
    }
}
