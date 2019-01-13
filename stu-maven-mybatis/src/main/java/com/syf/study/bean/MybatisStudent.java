package com.syf.study.bean;

import java.util.Date;
import java.util.List;

public class MybatisStudent {
	private Integer id;
	private String name;
	private Integer age;
	private Integer sex;
	private Date createDate;
	private Date updateDate;
	private Integer createBy;
	private Integer updateBy;
	//一对一，一学生对一班级
	private MybatisClass mybatisClass;
	//一对多，一学生对多订单
	private List<MybatisOrder> mybatisOrders;
	
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
	public List<MybatisOrder> getMybatisOrders() {
		return mybatisOrders;
	}
	public void setMybatisOrders(List<MybatisOrder> mybatisOrders) {
		this.mybatisOrders = mybatisOrders;
	}
	@Override
	public String toString() {
		return "MybatisStudent [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", createDate="
				+ createDate + ", updateDate=" + updateDate + ", createBy=" + createBy + ", updateBy=" + updateBy
				+ ", mybatisClass=" + mybatisClass + ", mybatisOrders=" + mybatisOrders + "]";
	}
	
	

	
	

}
