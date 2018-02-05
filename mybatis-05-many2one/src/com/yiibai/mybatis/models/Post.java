package com.yiibai.mybatis.models;

import java.io.Serializable;

public class Post implements Serializable {
	private static final long serialVersionUID = -3021806342684829439L;
	
	private int id;
	private User user;
	private String title;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public String toString() {
		return "Post [id=" + id + ", user=" + user + ", title=" + title + ", content=" + content + "]";
	}
}