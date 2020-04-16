package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * @author taobaibai
 * @create 2020-04-16 9:19
 */
public class MakerClientThread extends Thread {
    private final ActiveObject activeObject;
    private final char fillChar;

    public MakerClientThread(ActiveObject activeObject, String name) {
        super(name);
        this.activeObject = activeObject;
        this.fillChar = name.charAt(0);
    }

    @Override
    public void run() {
        try {
            for (int i = 0; true; i++) {
                Result result = activeObject.makeString(i+1, fillChar);
                Thread.sleep(20);
                String val = (String)result.getResultVal();
                System.out.println(Thread.currentThread().getName()+": value="+val);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
