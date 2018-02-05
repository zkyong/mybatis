package com.yiibai.mybatis.mapper;

import com.yiibai.mybatis.models.User;

public interface UserMapper {
	
	int insert(User record); 
	
	User selectUserById(int id);
}
