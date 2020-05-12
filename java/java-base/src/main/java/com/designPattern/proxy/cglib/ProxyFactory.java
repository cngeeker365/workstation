package com.designPattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

	private Object target;
	
	public ProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}


	public Object intercept(Object arg0, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("Cglib����ģʽ ~~ ��ʼ");
		Object returnVal = proxy.invokeSuper(arg0, args);
//		Object returnVal = method.invoke(target, args);
		System.out.println("Cglib����ģʽ ~~ �ύ");
		return returnVal;
	}

}
