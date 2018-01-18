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
@WebServlet(name = "ForwardDemo1", value = "/ForwardDemo1")
public class ForwardDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request对象将请求转发给ForwardDemo2, 参数是相对于项目的路径
        // 统一采用绝对路径
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("ForwardDemo1响应内容");
        response.setHeader("name", "haha");
        request.getRequestDispatcher("/ForwardDemo2").forward(request, response);

    }
}
