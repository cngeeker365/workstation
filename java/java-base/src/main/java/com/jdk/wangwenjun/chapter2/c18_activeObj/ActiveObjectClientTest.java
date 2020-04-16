package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 9:22
 */
public class ActiveObjectClientTest {
    public static void main(String[] args) {
        ActiveObject activeObject = ActiveObjectFactory.createActiveObject();
        new MakerClientThread(activeObject, "Alice").start();
        new MakerClientThread(activeObject, "Bobby").start();

        new DisplayClientThread("Chris", activeObject).start();
    }
}
