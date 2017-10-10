package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netease.course.service.ProductService;
import com.netease.course.service.UserService;

/**
 * @author menglanyingfei
 * @date 2017-8-26
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 加载Spring相关配置文件
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"application-context.xml");

		// 获取UserService实例
		UserService userService = applicationContext.getBean(UserService.class);
		// 调用方法
		try {
			userService.add("ZhangSan");
		} catch (Exception e) {
			// 暂不处理
		}
		// 获取ProductService实例
		ProductService productService = applicationContext
				.getBean(ProductService.class);
		// 调用方法
		productService.del("LiSi");

		((ConfigurableApplicationContext) applicationContext).close();
	}

}
