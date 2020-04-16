package com.jdk.wangwenjun.chapter3.c05_namespace;

import com.jdk.wangwenjun.chapter3.c04_noParent.SimpleClassLoader;
import com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject;

/**
 * @author taobaibai
 * @create 2020-04-16 21:50
 */
public class RuntimePackage {
    /**
     * 1. 包名：com.jdk.wangwenjun.chapter3.c05_namespace
     * 2. 运行时包名：Boot.Ext.App.com.jdk.wangwenjun.chapter3.c05_namespace，起到保护作用
     *      例如：
     *          [1] Boot.Ext.App.com.jdk.wangwenjun.chapter3.c04_noParent.SimpleClassLoaderTest
     *          [2] Boot.Ext.App.SimpleClassLoader.com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject
     *          [1] 看不到 [2]，运行时包不同
     */
    public static void main(String[] args) throws Exception{
        SimpleClassLoader classLoader = new SimpleClassLoader();
        Class clazz = classLoader.loadClass("com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject");
        /**
         * com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject cannot be cast to com.jdk.wangwenjun.chapter3.c04_noParent.SimpleObject
         */
        SimpleObject simpleObject = (SimpleObject)clazz.newInstance();
    }

}
