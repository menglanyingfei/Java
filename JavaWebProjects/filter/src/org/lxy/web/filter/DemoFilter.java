package org.lxy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author menglanyingfei
 * @date 2017-5-18
 */

/**
 * Filter入门
 * 1. 创建一个类, 实现Filter接口
 * 2. 重写方法
 * 3. 在web.xml文件中配置
 * @author 15072
 *
 */
public class DemoFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		//System.out.println("只加载一次...");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("进行过滤操作...");
		
		// 放行
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		//System.out.println("Filter被销毁了...");
	}

}






















