package com.jdk.wangwenjun.chapter2.c17_workerThread;

/**
 * @author taobaibai
 * @create 2020-04-15 21:54
 */
public class Request {
    private final String name;
    private final int number;

    public Request(final String name, final int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName() + " execute " + this);
    }

    @Override
    public String toString() {
        return "Request => No. \t" + number +"\t"+name;
    }
}
