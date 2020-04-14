package com.jdk.wangwenjun.chapter2.c06_readWriteLock;

/**
 * @author taobaibai
 * @create 2020-04-14 19:35
 */
public class SharedData {
    private final char[] buffer;

    private final ReadWriteLock lock = new ReadWriteLock();

    public SharedData(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]='*';
        }
    }

    public char[] read(){
        try {
            lock.readLock();
            return doRead();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readUnlock();
        }
        return null;
    }

    private char[] doRead() {
        char[] newBuffer = new char[buffer.length];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i]=buffer[i];
        }
        slowly(50);
        return newBuffer;
    }

    private void slowly(int mills){
        try {
            Thread.sleep(mills);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(char c) {
        try {
            lock.writeLock();
            this.doWrite(c);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c){
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            slowly(10);
        }
    }
}
