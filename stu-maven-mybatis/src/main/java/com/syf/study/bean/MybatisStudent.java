package com.syf.study.bean;

import java.util.Date;

public class MybatisStudent {
	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;
	private Date createDate;
	private Date updateDate;
	private MybatisClass mybatisClass;
	private Integer createBy;
	private Integer updateBy;
	
	
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
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
		return "MybatisStudent [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", mybatisClass=" + mybatisClass + ", createBy="
				+ createBy + ", updateBy=" + updateBy + "]";
	}
	
	

}
