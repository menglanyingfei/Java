package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		Calculator calculator = context.getBean("calculator", Calculator.class);
		
		System.out.println(calculator.add(1, 1));
		System.out.println(calculator.sub(5, 2));
		System.out.println("====================");
		System.out.println(calculator.getClass());

		((ConfigurableApplicationContext) context).close();
	}
}
