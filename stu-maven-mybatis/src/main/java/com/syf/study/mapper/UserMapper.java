package com.syf.study.mapper;

import java.util.List;

import java.util.Map;

import javax.swing.text.AbstractDocument.Content;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.LruCache;

import com.syf.study.bean.User;
//mybatis¶þ¼¶»º´æ
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
	
	List<User> queryPage(User user);
	User  callQueryById(@Param("id")Integer id);
}
