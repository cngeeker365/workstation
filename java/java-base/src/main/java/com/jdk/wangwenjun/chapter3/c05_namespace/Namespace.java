package com.jdk.wangwenjun.chapter3.c05_namespace;

/**
 * @author taobaibai
 * @create 2020-04-16 21:45
 */
public class Namespace {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = Namespace.class.getClassLoader();
        Class c1 = classLoader.loadClass("java.lang.String");
        Class c2 = classLoader.loadClass("java.lang.String");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
