package com.jdk.wangwenjun.chapter2.c08_future;

/**
 * 同步调用
 * @author taobaibai
 * @create 2020-04-14 22:21
 */
public class SyncInvoker {
    public static void main(String[] args) {
        //十秒后才能拿到数据
        String result = get();
        System.out.println(result);
    }
    private static String get(){
        try {
            Thread.sleep(100_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "FINISH";
    }
}
