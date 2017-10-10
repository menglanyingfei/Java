package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-16
 */
public class TestContainer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		ScrewDriver screwDriver = context.getBean("screwDriver", ScrewDriver.class);
		screwDriver.setColor("green");
		screwDriver.use();
		
		ScrewDriver screwDriver1 = context.getBean("screwDriver", ScrewDriver.class);
		screwDriver1.use();
		
		((ConfigurableApplicationContext) context).close();
		
	}

}
