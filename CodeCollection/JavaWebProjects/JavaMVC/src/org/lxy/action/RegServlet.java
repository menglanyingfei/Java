package org.lxy.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lxy.service.RegService;
import org.lxy.utils.MyXmlUtil;
import org.lxy.vo.User;

import com.sun.org.apache.commons.beanutils.BeanUtils;

/**
 * @author menglanyingfei
 * @date 2017-3-17
 */
public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 8883273124775616724L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 1. 获取参数列表
		 * 2. 需要把数据封装到JavaBean中, 使用BeanUtils开发包
		 * 3. 处理数据, 调用另一个JavaBean中
		 * 4. 把结果返回到页面中
		 */
		// 设置request缓冲区的编码(post)
		request.setCharacterEncoding("UTF-8");
		// 设置字符中文乱码
		response.setContentType("text/html;charset=UTF-8");
		
		// 获取session中的验证码
		String sessCode = (String) request.getSession().getAttribute("code");
		// 获取页面的验证码
		String reqCode = request.getParameter("code");
		// 判断
		if (reqCode == null || !reqCode.equals(sessCode)) {
			request.setAttribute("msg", "验证码输入错误");
			request.getRequestDispatcher("/reg/reg.jsp").forward(request, response); 
			return;
		}
		// 获取请求头
		String referer = request.getHeader("referer");
		if (referer == null || !referer.endsWith("reg.jsp")) {
			// 做处理
			// 获取虚拟路径
			// request获取客户机的信息(重定向)
			response.sendRedirect(request.getContextPath() + "/reg/reg.jsp"); // 加项目名
			return;
		}
		
		// 获取参数列表
		@SuppressWarnings("unchecked")
		Map<String, String []> map = request.getParameterMap();
		
		User user = new User();
		// 获取数据(BeanUtils)
		try {
			BeanUtils.populate(user, map);
			// 处理注册业务的类
			RegService reg = new RegService();
			int flag = reg.regUser(user);
			
			
			if (flag == MyXmlUtil.NAMEEXIST) {
				// 用户名重名了
				// 转发注册页面
				request.setAttribute("msg", "用户名已存在");
				// 转发
				request.getRequestDispatcher("/reg/reg.jsp").forward(request, response);
			} else if (flag == MyXmlUtil.EMAILEXIST) {
				// 邮箱重名了
				request.setAttribute("msg", "邮箱已存在");
				// 转发
				request.getRequestDispatcher("/reg/reg.jsp").forward(request, response);
			} else if (flag == MyXmlUtil.SUCCESS) {
				// 注册成功
				// 跳转登录页面
				response.getWriter().write("注册成功了");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
