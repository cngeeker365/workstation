package com.jdk.wangwenjun.chapter2.c16_2PhaseTermination;

import java.io.IOException;

/**
 * @author taobaibai
 * @create 2020-04-15 21:25
 */
public class AppServerClient {
    public static void main(String[] args) throws InterruptedException, IOException {
        AppServer server = new AppServer(12345);
        server.start();

        Thread.sleep(45_000);
        server.shutdown();
    }
}
