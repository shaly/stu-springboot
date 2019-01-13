package com.syf.study.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.syf.study.bean.MybatisOrder;

public interface MybatisOrderMapper {
	public List<MybatisOrder > queryOrdersByUserId(@Param("userId") Integer userId);
	
	public MybatisOrder queryOrderAndCourse(Integer id);
	
	
}
