package com.jdk.wangwenjun.chapter2.c18_activeObj;

/**
 * 包可见
 * @author taobaibai
 * @create 2020-04-16 8:33
 */
class Servant implements ActiveObject{
    @Override
    public Result makeString(int count, char fillChar) {
        char[] buf = new char[count];
        for (int i = 0; i < count; i++) {
            buf[i]=fillChar;
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return new RealResult(new String(buf));
    }

    @Override
    public void displayString(String text) {
        try {
            System.out.println("Display: " + text);
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
