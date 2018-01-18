package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/11.
 */
public class ServletDemo3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // response设置状态码:
        // 设置错误状态码
//        response.sendError(405, "就是不让你访问!");

        // 使用302实现重定向的状态码
        response.setStatus(302);
        // 设置location响应头, 告诉客户端该重定向到哪去
//        response.setHeader("Location", "http://www.baidu.com");

        // 也可以使用相对路径, 但不建议
//        response.setHeader("Location", "/day_1_11/index.jsp");

        // 重定向的快捷方式
        response.sendRedirect("/day_1_11/index.jsp");
    }
}
