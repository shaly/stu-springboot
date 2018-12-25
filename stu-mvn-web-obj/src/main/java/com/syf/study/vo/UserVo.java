package com.syf.study.vo;

public class UserVo {
	private String account;
	private String password;
	private String code;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "UserVo [account=" + account + ", password=" + password + ", code=" + code + "]";
	}
	
	
	
	
}
