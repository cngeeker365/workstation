package com.jdk.wangwenjun.chapter2.c07_immutable;

/**
 * @author taobaibai
 * @create 2020-04-14 20:07
 */
public class UsePersonThread extends Thread {
    private Person person;

    public UsePersonThread(Person person) {
        this.person = person;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName() + " print " + person.toString());
        }
    }
}
