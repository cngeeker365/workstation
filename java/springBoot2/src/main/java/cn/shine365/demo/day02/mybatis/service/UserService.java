package cn.shine365.demo.day02.mybatis.service;

import cn.shine365.demo.day02.mybatis.domain.User;

public interface UserService {

	public int add(User user);

	/**
	 * 控制事务测试
	 */
	public int addAccount();
	
}
