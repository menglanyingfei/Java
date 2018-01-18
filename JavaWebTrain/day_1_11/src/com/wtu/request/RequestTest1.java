package com.wtu.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/11.
 */
@WebServlet(name = "RequestTest1", value = "/RequestTest1")
public class RequestTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 1. 通过request对象获取referer请求头的值
        String refValue = request.getHeader("referer");
        if (refValue == null || !refValue.contains("localhost")) {
            // 重定向到百度
            response.sendRedirect("http://www.baidu.com");

        } else {
            response.getWriter().print("访问成功!!");
        }
    }
}
