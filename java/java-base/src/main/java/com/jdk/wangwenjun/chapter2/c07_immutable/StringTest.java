package com.jdk.wangwenjun.chapter2.c07_immutable;

/**
 * @author taobaibai
 * @create 2020-04-14 20:14
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = s1.replace("l", "k");
        System.out.println(s1.getClass()+" "+s1.hashCode());
        System.out.println(s2.getClass()+" "+s2.hashCode());
    }
}
