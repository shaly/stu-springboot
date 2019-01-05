package com.syf.study.mapper;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.syf.study.bean.User;

public interface UserMapper {
	List<User> queryAll();
	
	int addUser(User user);
	
	int updateUser(User user);
	
	int deleteUser(Integer id);
	List<User> queryContent(Map<String, String> queryMap);
	User queryByPrimaryKey(Integer id);
	
	List<User> queryLike(User user);

	List<User> queryLikeIngnorBigSmall(User user);
	List<User>  queryByAge(@Param("age")Integer age);
}
