package com.wtu.servletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by menglanyingfei on 2018/1/10.
 */
public class ServletConfigDemo1 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("ServletConfigDemo1实例化！！！");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletConfig对象
            获取: this.getServletConfig()
            方法:

                getInitParameter(String name)  获取初始化参数
                getInitParameterNames()        获取所有的初始化参数的名称
                String getServletName()        获得Servlet的名字

         */

        ServletConfig config = this.getServletConfig();
        response.getWriter().print(config.getServletName() + " ");
        // 根据参数名字获取参数的值
        String value = config.getInitParameter("aaa");
        response.getWriter().print(value + " ");

        // 获取所有的初始化参数名称
        Enumeration<String> names = config.getInitParameterNames();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value1 = config.getInitParameter(name);
            response.getWriter().print(value1 + "\n");
        }
    }
}
















