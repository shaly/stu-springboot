package com.syf.study.bean;

import java.util.Date;
import java.util.List;

public class Car {
	private Integer id;
	private String carName;
	private String carType;
	private Date createDate;
	private Integer createBy;
	private Integer status;
	private List<Integer> statusList;
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carType=" + carType + ", createDate=" + createDate
				+ ", createBy=" + createBy + ", status=" + status + ", statusList=" + statusList + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<Integer> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}
	
	

}
