package com.syf.study.mapper;

import java.util.List;

import com.syf.study.bean.User;

public interface UserMapper {
	List<User> queryAll();
	
	int addUser(User user);
	
	int updateUser(User user);
	int deleteUser(Integer id);
}
