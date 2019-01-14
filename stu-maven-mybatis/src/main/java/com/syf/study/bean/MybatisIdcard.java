package com.syf.study.bean;

import java.io.Serializable;

public class MybatisIdcard implements Serializable {

	private Integer id;
	private Integer idcard;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdcard() {
		return idcard;
	}
	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}
	@Override
	public String toString() {
		return "MybatisIdcard [id=" + id + ", idcard=" + idcard + "]";
	}
	
	
}
