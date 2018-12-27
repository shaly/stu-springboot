package com.syf.study.bean;

import java.util.Date;

import org.apache.ibatis.type.Alias;
@Alias("test__user")//mybatis-config中typeAliases设置别名，
//加上@Alias将别名设置为"test__user",如果不设置@Alias，对象类别名时默认为类名[不区分大小写]
public class TestUser {
     private Integer id;
	 private String name;
	 private Integer age;
	 private String sex;
	 private Date birthday;
	 private String classes;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + ", birthday=" + birthday
				+ ", classes=" + classes + "]";
	}
	
	
	
	
	
	
	
}
