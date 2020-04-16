package com.jdk.wangwenjun.chapter3.c02_myclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author taobaibai
 * @create 2020-04-16 17:38
 */
public class MyClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        MyClassLoader classLoader = new MyClassLoader("MyClassLoader");
        Class clazz = classLoader.loadClass("com.jdk.wangwenjun.chapter3.c02_myclassloader.MyObject");
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());

        Object obj = clazz.newInstance();
        Method method = clazz.getMethod("hello", new Class[]{});
        Object result = method.invoke(obj, new Object[]{});
        System.out.println(result);
    }
}
