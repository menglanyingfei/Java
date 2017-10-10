package org.lxy.web.filter;

import java.io.IOException;
import java.util.Enumeration;

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
public class Demo1Filter implements Filter {

	@SuppressWarnings("unchecked")
	public void init(FilterConfig filterConfig) throws ServletException {
		// 1. 获取Filter名称
		String filterName = filterConfig.getFilterName();

		System.out.println(filterName);
		// 2.获取初始化参数
		String encoding = filterConfig.getInitParameter("encoding");
		System.out.println(encoding);

		Enumeration<String> names = filterConfig.getInitParameterNames();
		while (names.hasMoreElements()) {
			System.out.println(names.nextElement());
		}

		// 3. 获取ServletContext对象
		filterConfig.getServletContext();
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("demo1Filter进行过滤操作...");

		// 放行
		chain.doFilter(request, response);

	}

	public void destroy() {
	}

}
