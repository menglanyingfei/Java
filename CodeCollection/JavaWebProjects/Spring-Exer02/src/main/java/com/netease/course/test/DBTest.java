package com.netease.course.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.course.dao.UserDao;
import com.netease.course.entity.User;
import com.netease.course.service.impl.UserAccountValidateService;

public class DBTest {
	@Autowired
	private UserDao dao;
	
	@Test
	public void TestQueryAndInsert() {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"application-context.xml");

		UserAccountValidateService uavs = ctx.getBean(
				"userAccountValidateService", UserAccountValidateService.class);
		System.out.println("DAO@Test is " + dao);
		User user1 = uavs.findUserByAccount("test1");
		System.out.println(user1.getUsername());
		System.out.println(user1.getPassword());
		ctx.close();
	}
}
