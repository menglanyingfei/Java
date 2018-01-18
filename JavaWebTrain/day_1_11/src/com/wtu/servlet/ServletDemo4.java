package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/11.
 */
public class ServletDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用response设置响应头
        response.setHeader("name", "gouwa");
        // 使用Content-type响应头来告诉浏览器编码格式
        response.setContentType("text/html;charset=utf-8");

        // 该方法和上面的方法效果是一样的
//        response.setHeader("Content-type", "text/html;charset=utf-8");

        // 使用Refresh响应头来完成页面的定时跳转
        response.getWriter().print("注册成功, 3秒后跳转到主页!");
        response.setHeader("refresh", "3;URL=http://www.baidu.com");

    }
}



















