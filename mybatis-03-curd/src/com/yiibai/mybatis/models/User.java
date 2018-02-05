package com.yiibai.mybatis.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 3198360718250005975L;
	
	private int id;
	private String name;
	private String dept;
	private String phone;
	private String website;
	
	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}