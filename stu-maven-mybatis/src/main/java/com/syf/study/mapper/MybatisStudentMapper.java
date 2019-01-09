package com.syf.study.mapper;

import java.util.List;

import com.syf.study.bean.MybatisStudent;

public interface MybatisStudentMapper {
	
	public MybatisStudent queryById(Integer id);
	

	public List<MybatisStudent> queryAll();

}
