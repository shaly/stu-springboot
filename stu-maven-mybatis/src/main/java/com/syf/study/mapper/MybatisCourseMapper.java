package com.syf.study.mapper;

import java.util.List;

import com.syf.study.bean.MybatisCourse;

public interface MybatisCourseMapper {
	
	public List<MybatisCourse> queryCourseByOrderId(Integer i);

}
