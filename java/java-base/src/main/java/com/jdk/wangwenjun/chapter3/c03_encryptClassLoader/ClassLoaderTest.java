package com.jdk.wangwenjun.chapter3.c03_encryptClassLoader;

/**
 * @author taobaibai
 * @create 2020-04-16 17:38
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        /**
         * java.lang.ClassFormatError: Incompatible magic value 889275713 in class file com/jdk/wangwenjun/chapter3/c02_myclassloader/MyObject
         */
//        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
//        classLoader.setDir("F:\\");
        DecryptClassLoader classLoader = new DecryptClassLoader();
        Class clazz = classLoader.loadClass("com.jdk.wangwenjun.chapter3.c02_myclassloader.MyObject");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());

    }
}
