package com.netease.course;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-22
 */
public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		/*
		JdbcTemplateDao dao = context.getBean("jdbcTemplateDao", JdbcTemplateDao.class);
		//dao.createTable();
		//dao.insertData();
		
		System.out.println(dao.count());
		
		List<User> userList = dao.getUserList();
		for (User user : userList) {
			System.out.println(user.getId() + ": " + user.getFirstName() + " " + user.getLastName());
		}
		*/
		
		
		AccountDao dao = context.getBean("accountDao", AccountDao.class);
		dao.resetMoney();
		
		try {
			dao.transferMoney("li", "han", 520);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<UserBalance> accountList = dao.accountList();
		for (UserBalance account : accountList) {
			System.out.println(account.getUser() + ": " + account.getBalance());
		}
		
		
		/*
		MybatisUserDao dao = context.getBean("mybatisUserDao", MybatisUserDao.class);
		List<User> userList = dao.getUserList();
		for (User user : userList) {
			System.out.println(user.getFirstName() + " " + user.getLastName());
		}
		
		User liLei = dao.getUser("Lei");
		System.out.println("getByFirstName: " + liLei.getFirstName() + " " + liLei.getLastName());
		*/
		
		((ConfigurableApplicationContext) context).close();
	}

}



