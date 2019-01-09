package com.syf.study.bean;

import java.util.List;

public class MybatisClass {
	private Integer id;
	private String className;
	private String desc;
	
	List<MybatisStudent> users;
	
	
	public List<MybatisStudent> getUsers() {
		return users;
	}
	public void setUsers(List<MybatisStudent> users) {
		this.users = users;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Override
	public String toString() {
		return "MybatisClass [id=" + id + ", className=" + className + ", desc=" + desc + ", users=" + users + "]";
	}
	
	

}
