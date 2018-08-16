package com.zjrc.sxzz.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjrc.sxzz.dao.UserDao;
import com.zjrc.sxzz.entity.User;
import com.zjrc.sxzz.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUserByMobile(String mobile) {
		return userDao.selectByMobile(mobile);
	}

}
