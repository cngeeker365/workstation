package com.jdk.wangwenjun.chapter2.c11_context.threadLocalCtx;

/**
 * @author taobaibai
 * @create 2020-04-15 15:02
 */
public final class ActionContext {
    private static final ThreadLocal<Context> threadLocal = new ThreadLocal<Context>(){
        @Override
        protected Context initialValue() {
            return new Context();
        }
    };

    private static class ContextHolder{
        private final static ActionContext actionContext = new ActionContext();
    }

    public static ActionContext getActionContext(){
        return ContextHolder.actionContext;
    }

    public Context getContext(){
        return threadLocal.get();
    }
}
