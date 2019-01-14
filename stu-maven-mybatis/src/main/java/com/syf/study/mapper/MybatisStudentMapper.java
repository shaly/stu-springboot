package com.syf.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cache.decorators.LruCache;

import com.syf.study.bean.MybatisStudent;

public interface MybatisStudentMapper {
	
	public MybatisStudent queryById(Integer id);
	

	public List<MybatisStudent> queryAll();
	public MybatisStudent queryByClassId(@Param("classid") Integer classid);
	public MybatisStudent queryUserOrdersByUserId(@Param("userId") Integer userId);
	
}
