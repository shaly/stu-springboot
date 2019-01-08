package com.syf.study.bean;

public class MybatisStudent {
	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;
	private MybatisClass mybatisClass;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public MybatisClass getMybatisClass() {
		return mybatisClass;
	}
	public void setMybatisClass(MybatisClass mybatisClass) {
		this.mybatisClass = mybatisClass;
	}
	@Override
	public String toString() {
		return "MybatisStudent [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", mybatisClass="
				+ mybatisClass + "]";
	}
	

}
