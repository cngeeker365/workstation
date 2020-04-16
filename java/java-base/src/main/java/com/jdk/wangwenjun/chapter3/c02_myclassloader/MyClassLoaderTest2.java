package com.jdk.wangwenjun.chapter3.c02_myclassloader;

/**
 * 1. 类加载器的委托是优先交给父加载器先去尝试加载
 * 2. 父加载器和子加载器是一种包装关系，或包含关系
 * @author taobaibai
 * @create 2020-04-16 17:38
 */
public class MyClassLoaderTest2 {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader1 = new MyClassLoader("MyClassLoader");
        MyClassLoader classLoader2 = new MyClassLoader("MyClassLoader", classLoader1);
        classLoader2.setDir("F:\\");

        Class clazz2 = classLoader2.loadClass("com.jdk.wangwenjun.chapter3.c02_myclassloader.MyObject");
        System.out.println(clazz2.hashCode());
        Class clazz1 = classLoader1.loadClass("com.jdk.wangwenjun.chapter3.c02_myclassloader.MyObject");
        System.out.println(clazz1.hashCode());
//        System.out.println(((MyClassLoader)clazz2.getClassLoader()).getClassLoaderName());
    }
}
