package com.jdk.wangwenjun.chapter2.c11_context.basePassCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:20
 */
public class QueryFromDBAction {
    public void execute(Context context){
        try {
            Thread.sleep(1000);
            String name = "Alex --> "+Thread.currentThread().getName();
            context.setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
