package com.syf.study.bean;

public class MybatisOrderCourse {
	private Integer userId         ;
	private Integer courseId       ;
	private Integer orderId        ;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	@Override
	public String toString() {
		return "MybatisOrderCourse [userId=" + userId + ", courseId=" + courseId + ", orderId=" + orderId + "]";
	}

}
