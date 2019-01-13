package com.syf.study.bean;

import java.util.Date;
import java.util.List;

public class MybatisCourse {
	private Integer id;
	private String title;
	private String content;
	private String description;
	private Double price;
	private Date createTime;
	private Integer status;
	private Integer isDelete;
	//一个课程可以有多个订单
	private List<MybatisOrder> orders;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public List<MybatisOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<MybatisOrder> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "MybatisCourse [id=" + id + ", title=" + title + ", content=" + content + ", description=" + description
				+ ", price=" + price + ", createTime=" + createTime + ", status=" + status + ", isDelete=" + isDelete
				+ ", orders=" + orders + "]";
	}

	

	

}
