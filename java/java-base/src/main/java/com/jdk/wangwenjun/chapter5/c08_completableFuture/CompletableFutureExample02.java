package com.jdk.wangwenjun.chapter5.c08_completableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author taobaibai
 * @create 2020-04-21 15:49
 */
public class CompletableFutureExample02 {
    private static void sleep(long num, TimeUnit type) {
        try {
            switch (type) {
                case SECONDS:
                    TimeUnit.SECONDS.sleep(num);
                    break;
                case MILLISECONDS:
                    TimeUnit.MILLISECONDS.sleep(num);
                    break;
                default:
                    TimeUnit.HOURS.sleep(num);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSupplyAsync() throws Exception {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")     //【0】返回值-->String
                                                    //【1】改变返回值-->Integer
//                                                .thenApply(String::length)

                                                    //【2】改变返回值-->Integer
//                                                .thenApplyAsync( s -> {
//                                                    System.out.println("=================");
//                                                    sleep(3, TimeUnit.SECONDS);
//                                                    return s.length();
//                                                })

                                                    //【3】改变返回值-->Integer, 可处理异常
//                                                .handleAsync((s,t)->{
//                                                    Optional.of(t).ifPresent(e -> System.out.println("Error"));
//                                                    return (s==null)?0:s.length();
//                                                })

                                                .whenComplete((v, t) -> System.out.println("done"));
        System.out.println(future.get());
        Thread.currentThread().join();
    }


    public static void main(String[] args) throws Exception {
        testSupplyAsync();
    }
}
