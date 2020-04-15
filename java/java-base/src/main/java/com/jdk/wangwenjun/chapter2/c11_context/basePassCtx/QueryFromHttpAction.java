package com.jdk.wangwenjun.chapter2.c11_context.basePassCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:25
 */
public class QueryFromHttpAction {
    public void execute(Context context){
        String name = context.getName();
        String cardID = getCardID(name);
        context.setCardID(cardID);
    }

    private String getCardID(String name){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "02384290384029322 --> "+Thread.currentThread().getName();
    }
}
