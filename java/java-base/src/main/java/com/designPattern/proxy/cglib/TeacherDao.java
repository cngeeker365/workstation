package com.designPattern.proxy.cglib;

import org.junit.BeforeClass;

public class TeacherDao {

	public String teach() {
		System.out.println("TeacherDao.teach Invoked");
		return "hello";
	}
}
