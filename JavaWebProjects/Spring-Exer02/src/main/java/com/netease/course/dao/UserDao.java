package com.netease.course.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.netease.course.entity.User;

@Repository
public interface UserDao {
	
	 @Insert("insert into `user` (`userName`,`userPassword`) values (#{username},#{password})")
	 public void addUser(User user);
	 
	 @Update("update `user` set `userName`=#{username} ,`userPassword`=#{password} where `userName` = #{username}")
	 public void update(User user);
	 
	 @Results({
		 @Result(property = "username", column = "userName"), 
		 @Result(property = "password", column = "userPassword")
	 })
	 @Select ("select * from `user` where userName=#{username}")
	 public User select(@Param("username") String username);
}
