package org.lxy.web.filter.demo3;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author menglanyingfei
 * @date 2017-5-19
 */
public class ImageCacheFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// 1. 强制转换
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
	
		// 2. 操作
		// 缓存10天
		response.setDateHeader("expires", System.currentTimeMillis() + 60*60*24*10*1000);
	
		// 3. 放行
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}
