package com.jdk.wangwenjun.chapter2.c08_future;

/**
 * 异步调用
 * Future           -> 代表的是未来的一个凭据
 * FutureTask       -> 将你的调用逻辑进行了隔离
 * FutureService    -> 桥接 Future 和 FutureTask
 *
 * @author taobaibai
 * @create 2020-04-14 22:21
 */
public class AsynInvoker {
    public static void main(String[] args) throws Exception{
        callbackMod();
//        waitMod();
    }

    public static void waitMod() throws Exception {
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(()->{
            try {
                Thread.sleep(100000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "FINISH";
        });
        System.out.println("========================================");
        System.out.println("Do Other Things.");
        Thread.sleep(1000);
        System.out.println("========================================");

        System.out.println(future.get());
    }

    public static void callbackMod() throws Exception{
        FutureService futureService = new FutureService();
        Future<String> future = futureService.submit(()->{
            try {
                Thread.sleep(100000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "FINISH";
            //差异，此处传入Consumer
        }, System.out::println);

        System.out.println("========================================");
        System.out.println("Do Other Things.");
        Thread.sleep(1000);
        System.out.println("========================================");
    }
}
