package com.jdk.wangwenjun.chapter2.c05_singleThreadExec;

/**
 * @author taobaibai
 * @create 2020-04-14 17:25
 */
public class Client {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("Baobao","Beijing",gate);
        User sh = new User("Shangbao","Shanghai",gate);
        User gz = new User("Guangbao","GuangZhou",gate);

        bj.start();
        sh.start();
        gz.start();

    }
}
