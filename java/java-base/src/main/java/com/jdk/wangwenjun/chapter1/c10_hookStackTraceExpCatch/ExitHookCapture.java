package com.jdk.wangwenjun.chapter1.c10_hookStackTraceExpCatch;

/**
 * @author taobaibai
 * @create 2020-04-12 21:46
 */
public class ExitHookCapture {
    public static void main(String[] args) throws InterruptedException {
        //添加钩子，一旦程序崩溃或退出，则要通知、并释放资源
        Runtime.getRuntime().addShutdownHook( new Thread(()->{
            System.out.println("The application will be exit.");
            notifyAndRelease();
        }));

        int i = 0;
        while (true) {
            Thread.sleep(1_000L);
            System.out.println("I am working...");

            i++;
            if (i > 20) {
                throw new RuntimeException("Error");
            }
        }
    }

    private static void notifyAndRelease() {
        System.out.println("notify to the admin.");
        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("release resources(sockets, files, connections, etc.)");
        try {
            Thread.sleep(1_000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Release and Notify Done.");
    }
}
