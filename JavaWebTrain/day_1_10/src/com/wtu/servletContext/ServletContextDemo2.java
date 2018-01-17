package com.wtu.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/10.
 */
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            ServletContext 作为域对象的使用
            可以使不同的Servlet之间实现数据的共享和传输

            将数据保存到域对象
            setAttribute(String name, String value)
            从域对象中获取数据
            getAttribute(String name)
            从域对象中删除数据
            removeAttribute(String name)
         */

        String name = "狗娃";
        // 获取ServletContext
        ServletContext application = this.getServletContext();
        System.out.println(application.getInitParameter("haha"));
        application.setAttribute("name", name);
    }
}
