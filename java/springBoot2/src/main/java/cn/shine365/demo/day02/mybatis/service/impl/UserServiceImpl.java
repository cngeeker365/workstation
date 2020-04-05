package cn.shine365.demo.day02.mybatis.service.impl;

import cn.shine365.demo.day02.mybatis.domain.User;
import cn.shine365.demo.day02.mybatis.mapper.UserMapper;
import cn.shine365.demo.day02.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

	 @Autowired
	 private UserMapper userMapper;
	 
	@Override
	public int add(User user) {
		userMapper.insert(user);
		int id = user.getId();
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
	public int addAccount() {
		User user = new User();
		user.setAge(88);
		user.setName("测试事务");
		user.setPhone("12312312312");
		user.setCreateTime(new Date());
		userMapper.insert(user);
		int i = 19/0;
		return 0;
	}

}
