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
public class FirstFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("FirstFilter被执行...");
		// 向下放行
		chain.doFilter(request, response);
		System.out.println("FirstFilter end...");
	}

	public void destroy() {
		
	}

}
