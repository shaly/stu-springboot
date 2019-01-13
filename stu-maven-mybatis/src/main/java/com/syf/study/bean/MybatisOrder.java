package com.syf.study.bean;

import java.util.Date;
import java.util.List;

public class MybatisOrder {
	private Integer id;
	private String orderNumber;
	private Date creatDate;
	private Double price;
	//一个订单 可以有多个课程
	private List<MybatisCourse> courses;
	
	private MybatisStudent mybatisStudent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public MybatisStudent getMybatisStudent() {
		return mybatisStudent;
	}

	public void setMybatisStudent(MybatisStudent mybatisStudent) {
		this.mybatisStudent = mybatisStudent;
	}

	public List<MybatisCourse> getCourses() {
		return courses;
	}

	public void setCourses(List<MybatisCourse> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "MybatisOrder [id=" + id + ", orderNumber=" + orderNumber + ", creatDate=" + creatDate + ", price="
				+ price + ", courses=" + courses + ", mybatisStudent=" + mybatisStudent + "]";
	}

	
	
	
	
	
	
	
	
}
