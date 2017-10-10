package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-17
 */
public class TestContainer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
//		ScrewDriver screwDriver = (ScrewDriver) context.getBean("screwDriver", ScrewDriver.class);
//		screwDriver.use();
		
		Header header = context.getBean("header", StraightHeader.class);
		System.out.println(header.getInfo());
		//header.doWork();
		
		ScrewDriver screwDriver = context.getBean("screwDriver", ScrewDriver.class);
		screwDriver.use();
		
		((ConfigurableApplicationContext) context).close();
	}	

}
