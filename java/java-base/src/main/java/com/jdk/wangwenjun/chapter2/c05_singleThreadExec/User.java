package com.jdk.wangwenjun.chapter2.c05_singleThreadExec;

/**
 * @author taobaibai
 * @create 2020-04-14 17:23
 */
public class User extends Thread {
    private final String myName;
    private final String myAddr;
    private final Gate gate;

    public User(String myName, String myAddr, Gate gate) {
        this.myName = myName;
        this.myAddr = myAddr;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName + " BEGIN");
        while (true){
            this.gate.pass(myName,myAddr);
        }
    }
}
