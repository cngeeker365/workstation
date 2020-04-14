package com.jdk.wangwenjun.chapter2.c05_singleThreadExec;

/**
 * Gate是共享资源（Shared Resource）
 * @author taobaibai
 * @create 2020-04-14 17:18
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String addr = "Nowhere";

    /**
     * 临界值，只能有一个线程通过
     * @param name
     * @param addr
     */
    public synchronized void pass(String name, String addr){
        this.counter++;
        /* 这里会出现锁竞争，解决方法：加 synchronized 的 this 锁 */
        this.name = name;
        this.addr = addr;
        verify();
    }

    //verify 读操作，此处实际也加锁了，加在了pass上，效率低
    private void verify(){
        if(this.name.charAt(0) != this.addr.charAt(0)){
            System.out.println("***********BROKEN***********\t" + toString());
        }
    }

    @Override
    public synchronized String toString() {
        return "Gate{" +
                "counter=" + counter +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
