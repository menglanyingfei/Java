package com.wtu.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "LoginServlet2", value = "/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 假设用户名为haha, 密码为123, 才能登录成功
        if ("haha".equals(username) && "123".equals(password)) {
            // 将用户信息保存到session中
            request.getSession().setAttribute("username", username);
            // 重定向到成功页面
            response.sendRedirect(request.getContextPath() + "/jsp/success.jsp");

        } else {
            // 登录失败, 保存错误信息到request中
            request.setAttribute("mess", "用户名或者密码错误!");
            request.getRequestDispatcher("/jsp/login2.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
