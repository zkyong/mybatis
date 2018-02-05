package com.yiibai.mybatis.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3198360718250005975L;
	
	private int userId;
	private String userName;
	private String userDept;
	private String userPhone;
	private String userWebsite;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserDept() {
		return userDept;
	}
	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserWebsite() {
		return userWebsite;
	}
	public void setUserWebsite(String userWebsite) {
		this.userWebsite = userWebsite;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userDept=" + userDept + ", userPhone="
				+ userPhone + ", userWebsite=" + userWebsite + "]";
	}

}