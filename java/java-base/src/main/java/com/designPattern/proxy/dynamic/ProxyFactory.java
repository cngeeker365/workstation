package com.designPattern.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {

	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	} 
	
	public Object getProxyInstance() {
		/*
		 *  public static Object newProxyInstance(ClassLoader loader,
                                          Class<?>[] interfaces,
                                          InvocationHandler h)
		 */
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), 
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("JDK����ʼ~~");
						Object returnVal = method.invoke(target, args);
						System.out.println("JDK�����ύ");
						return returnVal;
					}
				}); 
	}
	
	
}
