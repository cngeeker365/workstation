package com.jdk.wangwenjun.chapter3.c01_loadTest;

/**
 * @author taobaibai
 * @create 2020-04-16 14:49
 */
public class Singleton {
    //位置2
    private static Singleton instance = new Singleton();
    public static int x = 0;
    public static int y;
    //位置1
//    private static Singleton instance = new Singleton();

    /**
     * 位置1 分析：
     *      int x = 0
     *      int y = 0
     *      instance = null
     *      new{x++,y++} => {x=1, y=1}
     * 位置2 分析：
     *      instance = null
     *      x = 0
     *      y = 0
     *      instance = new Singleton
     *          x++
     *          y++
     *      x = 0
     *      y = 1
     */
    private Singleton(){
        x++;
        y++;
    }

    public static Singleton getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton = getInstance();
        System.out.println(x);
        System.out.println(y);
    }
}
