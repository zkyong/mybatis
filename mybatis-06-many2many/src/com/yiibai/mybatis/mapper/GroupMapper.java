package com.yiibai.mybatis.mapper;

import com.yiibai.mybatis.models.Group;

public interface GroupMapper {
	
	int insert(Group record);
	
	Group selectGroupById(int id);
}
