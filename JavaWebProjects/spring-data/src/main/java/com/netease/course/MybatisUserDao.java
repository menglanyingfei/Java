package com.netease.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author menglanyingfei
 * @date 2017-8-23
 */
public interface MybatisUserDao {
	// 添加映射
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	@Select("select * from user where first_name=#{firstName}")
	public User getUser(String firstName);

	// 添加映射
	@Results({ @Result(property = "id", column = "id"),
			@Result(property = "firstName", column = "first_name"),
			@Result(property = "lastName", column = "last_name") })
	@Select("Select * from user")
	public List<User> getUserList();
}
