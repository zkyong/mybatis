package com.yiibai.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yiibai.mybatis.models.Order;
import com.yiibai.mybatis.models.User;
import com.yiibai.util.Page;

public interface UserMapper {
	
	List<Order> selectUserOrders(int id);
	
	User selectUserById(int id);
	
	List<Order> selectOrderListPage(@Param("page") Page page, @Param("userId")int id);
}
