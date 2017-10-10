package com.netease.course.exercise;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author menglanyingfei
 * @date 2017-8-25
 */
public class TestFileWriterServiceImpl {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 加载spring的配置文件，创建容器
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application-context.xml");
		
		FileWriterService fileWriterService = applicationContext.getBean(
				"fileWriterService", FileWriterServiceImpl.class);
		// 调用业务逻辑
		fileWriterService.write("Hello World");
		// 关闭容器
		((ConfigurableApplicationContext) applicationContext).close();
	}

}
