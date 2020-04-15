package com.jdk.wangwenjun.chapter2.c11_context.threadLocalCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 11:20
 */
public class ExecutionTask implements Runnable {
    private QueryFromDBAction queryAction = new QueryFromDBAction();
    private QueryFromHttpAction httpAction = new QueryFromHttpAction();
    @Override
    public void run() {
        final Context context = ActionContext.getActionContext().getContext();
        queryAction.execute();
        System.out.println("Name Qry Succeed!");
        httpAction.execute();
        System.out.println("Card ID Qry Succeed!");
        System.out.println("User Name : [" + context.getName() + "], Card ID : [" + context.getCardID() + "]");
    }
}
