package com.designPattern.flyweight;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ����һ��������
		WebSiteFactory factory = new WebSiteFactory();

		// �ͻ�Ҫһ����������ʽ��������վ
		WebSite webSite1 = factory.getWebSiteCategory("新闻");

		
		webSite1.use(new User("tom"));

		// �ͻ�Ҫһ���Բ�����ʽ��������վ
		WebSite webSite2 = factory.getWebSiteCategory("博客");

		webSite2.use(new User("jack"));

		// �ͻ�Ҫһ���Բ�����ʽ��������վ
		WebSite webSite3 = factory.getWebSiteCategory("博客");

		webSite3.use(new User("smith"));

		// �ͻ�Ҫһ���Բ�����ʽ��������վ
		WebSite webSite4 = factory.getWebSiteCategory("博客");

		webSite4.use(new User("king"));
		
		System.out.println("��վ�ķ��๲=" + factory.getWebSiteCount());
	}

}
