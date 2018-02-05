package com.yiibai.mybatis.dao;

import java.util.List;

import com.yiibai.mybatis.models.Post;

public interface PostMapper {

	public List<Post> selectMany2One();
}