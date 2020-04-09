package com.jdk.highLevel.myMybatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taobaibai
 * @create 2020-04-06 21:12
 */
interface Executor{
    void execute(String statement);
}
class DefaultExecutor implements Executor{
    @Override
    public void execute(String statement) {
        System.out.println("execute: " + statement);
    }
}
class Invocation{
    private Object target;
    private Method method;
    private Object[] args;

    public Invocation(Object target, Method method, Object[] args) {
        this.target = target;
        this.method = method;
        this.args = args;
    }

    public Object process() throws Exception {
        return method.invoke(target, args);
    }
}
interface Interceptor{ //动态代理+责任链
    Object interceptor(Invocation invocation) throws Exception;
    Object plugin(Object target);
}
class LogInterceptor implements Interceptor{
    @Override
    public Object interceptor(Invocation invocation) throws Exception {
        System.out.println("exec start time: " + System.nanoTime());
        Object result = invocation.process();
        System.out.println("exec end time: " + System.nanoTime());
        return result;
    }

    @Override
    public Object plugin(Object target) {
        return TargetProxyFactory.newProxy(target, this);
    }
}
class TransactionInterceptor implements Interceptor{
    @Override
    public Object interceptor(Invocation invocation) throws Exception {
        System.out.println("Transaction start : " + System.nanoTime());
        Object result = invocation.process();
        System.out.println("Transaction end : " + System.nanoTime());
        return result;
    }
    @Override
    public Object plugin(Object target) {
        return TargetProxyFactory.newProxy(target, this);
    }
}
class InterceptorChain{
    private List<Interceptor> interceptors = new ArrayList<>();
    public void addInterceptor(Interceptor interceptor){
        this.interceptors.add(interceptor);
    }
    public Object pluginAll(Object target){
        for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
        }
        return target;
    }
}

class TargetProxyHandler implements InvocationHandler{
    private Object target;
    private Interceptor interceptor;

    public TargetProxyHandler(Object target, Interceptor interceptor) {
        this.target = target;
        this.interceptor = interceptor;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return interceptor.interceptor(new Invocation(target,method,args));
    }
}
class TargetProxyFactory{
    public static Object newProxy(Object target, Interceptor interceptor){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                        target.getClass().getInterfaces(),
                                        new TargetProxyHandler(target, interceptor));
    }
}
public class TestInterceptor {
    public static void main(String[] args) {
        Executor target = new DefaultExecutor();
        Interceptor logInterceptor = new LogInterceptor();
        Interceptor txInterceptor = new TransactionInterceptor();
        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor(logInterceptor);
        chain.addInterceptor(txInterceptor);
        Executor proxy = (Executor)chain.pluginAll(target);
        proxy.execute("select");
    }
}
