package com.jdk.wangwenjun.chapter2.c11_context.threadLocalCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:20
 */
public class QueryFromDBAction {
    public void execute(){
        try {
            Thread.sleep(1000);
            String name = "Alex --> "+Thread.currentThread().getName();
            ActionContext.getActionContext().getContext().setName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
