package com.designPattern.proxy.cglib;

public class Client {

	public static void main(String[] args) {
		TeacherDao target = new TeacherDao();
		TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();

		String res = proxyInstance.teach();
		System.out.println("res=" + res);

	}

}
