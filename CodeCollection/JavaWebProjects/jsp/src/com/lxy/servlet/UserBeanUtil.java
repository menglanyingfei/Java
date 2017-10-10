package com.lxy.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.lxy.utils.MyDateConverter;

import com.lxy.vo.User;

/**
 * 使用BeanUtils完成数据的封装
 * @author menglanyingfei
 * @date 2017-2-6
 */
public class UserBeanUtil extends HttpServlet {

	private static final long serialVersionUID = 432714527841570399L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 // 获取数据
		@SuppressWarnings("unchecked")
		Map<String, String []> map = request.getParameterMap();
		// 创建User对象
		User user = new User();
		// 完成注册
		ConvertUtils.register(new MyDateConverter(), Date.class);
		
		// 完成封装
		try {
			BeanUtils.populate(user, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		// 打印
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		/*System.out.println(user.getMoney());
		System.out.println(user.getBirthday());*/
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
