package com.netease.course;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-27
 * MyBatis事务尚未实现
 */
public class TestData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		//JdbcTemplateDao dao = context.getBean("jdbcTemplateDao", JdbcTemplateDao.class);
		JdbcTemplateDao dao = context.getBean(JdbcTemplateDao.class);
		dao.resetMoney();
		
		dao.transferMoney(1001L, 1002L, 500.0);
		
		List<UserBalance> userBalanceList = dao.userBalanceList();
		for (UserBalance userBalance : userBalanceList) {
			System.out.println(userBalance.getUserId() + ": " + userBalance.getBalance());
		}
		
		((ConfigurableApplicationContext) context).close();
	}

}
