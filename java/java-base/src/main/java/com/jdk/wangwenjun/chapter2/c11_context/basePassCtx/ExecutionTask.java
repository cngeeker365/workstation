package com.jdk.wangwenjun.chapter2.c11_context.basePassCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:20
 */
public class ExecutionTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();
    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context = new Context();
        queryAction.execute(context);
        System.out.println("Name Qry Succeed!");
        httpAction.execute(context);
        System.out.println("Card ID Qry Succeed!");
        System.out.println("User Name : [" + context.getName() + "], Card ID : [" + context.getCardID() + "]");
    }
}
