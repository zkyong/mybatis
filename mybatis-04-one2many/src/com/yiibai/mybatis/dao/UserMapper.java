package com.yiibai.mybatis.dao;

import java.util.List;

import com.yiibai.mybatis.models.User;

public interface UserMapper {

	public List<User> selectOne2Many(int id);
}