package com.yiibai.mybatis.mapper;

import java.util.List;

import com.yiibai.mybatis.models.Order;
import com.yiibai.mybatis.models.User;

public interface UserMapper {
	
	List<Order> selectUserOrders(int id);
	
	User selectUserById(int id);
}
