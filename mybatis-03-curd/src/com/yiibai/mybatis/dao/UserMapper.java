package com.yiibai.mybatis.dao;

import java.util.List;

//import org.apache.ibatis.annotations.Delete;
//import org.apache.ibatis.annotations.Insert;
//import org.apache.ibatis.annotations.Select;
//import org.apache.ibatis.annotations.Update;

//import org.apache.ibatis.annotations.Select;
import com.yiibai.mybatis.models.User;

public interface UserMapper {

	//@Select("select * from user where id = #{id}")
	public User selectByPrimaryKey(int id);

	//@Select("select * from user")
	public List<User> selectList();

	//@Insert("insert into user(id, name ,dept, phone, website) values (#{id}, #{name}, #{dept}, #{phone}, #{website})")
	public void insert(User user);

	//@Update("update user set name = #{name} where id = #{id}")
	public void update(User user);

	//@Delete("delete from user where id = #{id}")
	public void deleteByPrimaryKey(int id);
}