package org.lxy.listener.application;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class MyServletContextListener implements ServletContextListener{

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext对象被创建");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext对象被销毁");
	}
	
}
