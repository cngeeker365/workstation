package com.jdk.wangwenjun.chapter3.c01_loadTest;

/**
 * @author taobaibai
 * @create 2020-04-16 15:04
 */
public class LoadClass {
    public static void main(String[] args) {
        MyObject myObject1 = new MyObject();
        MyObject myObject2 = new MyObject();
        MyObject myObject3 = new MyObject();
        MyObject myObject4 = new MyObject();

        //class 是 同一份
        System.out.println(myObject1.getClass() == myObject2.getClass());
        System.out.println(myObject1.getClass() == myObject3.getClass());
        System.out.println(myObject1.getClass() == myObject4.getClass());

        System.out.println(MyObject.x);
    }
}

class MyObject{
    public static int x = 10;
}
