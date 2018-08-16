package com.zjrc.sxzz.dao;

import org.apache.ibatis.annotations.Param;

import com.zjrc.sxzz.entity.User;

public interface UserDao {
	
	User selectByMobile(@Param("mobile")String mobile);
}
