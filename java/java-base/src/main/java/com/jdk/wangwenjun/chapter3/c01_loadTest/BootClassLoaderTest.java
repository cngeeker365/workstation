package com.jdk.wangwenjun.chapter3.c01_loadTest;

/**
 * @author taobaibai
 * @create 2020-04-16 17:05
 */
public class BootClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));

        Class<?> clazz = Class.forName("com.jdk.wangwenjun.chapter1.c00_firstTry.TryCurrency_01");
        System.out.println(clazz.getClassLoader());
        System.out.println(clazz.getClassLoader().getParent());
        System.out.println(clazz.getClassLoader().getParent().getParent());

        //父委托机制
        Class<?> klass = Class.forName("java.lang.String");
        System.out.println(klass);
        System.out.println(klass.getClassLoader());
    }
}
