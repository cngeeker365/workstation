package com.jdk.wangwenjun.chapter3.c04_noParent;

/**
 * @author taobaibai
 * @create 2020-04-16 21:21
 */
public class SimpleClassLoaderTest {
    public static void main(String[] args) throws Exception {
        SimpleClassLoader classLoader = new SimpleClassLoader();
        Class clazz = classLoader.loadClass("com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject");
        System.out.println(clazz.getClassLoader());
    }
}
