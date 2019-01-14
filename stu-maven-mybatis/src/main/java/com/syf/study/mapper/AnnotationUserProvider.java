package com.syf.study.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.syf.study.bean.User;

public class AnnotationUserProvider {
	
	public String selectWithUserParams(User u) {
		return new SQL() {
			{
				SELECT("*");
				FROM("USER");
				WHERE(" name=#{name} and age=#{age} and createby=#{createBy}");
				ORDER_BY("createtime desc");
				
			}
		}.toString();
	}

	public String queryWithProviderId(Integer id) {
		return new SQL() {
			{
				SELECT("*");
				FROM("USER");
				WHERE("id = #{userId}");//名字可以自定义
			}
		}.toString();
	}

	public String addWithProviderMap(Map<String, Object> m) {
		return new SQL() {
			{
				INSERT_INTO("user");
				VALUES("name","#{name}");
				VALUES("age","#{age}");
				VALUES("createTime","#{createTime}");
				VALUES("updateTime","#{updateTime}");
				VALUES("createBy","#{createBy}");
				VALUES("updateBy","#{updateBy}");
			}
		}.toString();
	}
	
	public String addWithProvider(User u) {
		return new SQL() {
			{
				INSERT_INTO("user");
				VALUES("name","#{name}");
				VALUES("age","#{age}");
				VALUES("createTime","#{createTime}");
				VALUES("updateTime","#{updateTime}");
				VALUES("createBy","#{createBy}");
				VALUES("updateBy","#{updateBy}");
			}
		}.toString();
	}
	
	public String updateWithProvider(User u) {
		return new SQL() {
			{
				UPDATE("USER");
				SET("name=#{name}");
				SET("age=#{age}");
				SET("birthday=#{birthday}");
				WHERE("id =#{id}");
			}
		}.toString();
	}

	public String delWithProvider(Integer id) {
		return new SQL() {
			{
				DELETE_FROM("USER");
				WHERE("ID =#{id}");
			}
		}.toString();
	}
	
}
