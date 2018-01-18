package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 请求乱码
        request.setCharacterEncoding("utf-8");

        // 获取用户名并且保存到Cookie中
        String username = request.getParameter("username");
        // 编码
        username = URLEncoder.encode(username, "utf-8");

        Cookie cookie = new Cookie("username", username);
        // 设置cookie保存到硬盘中
        cookie.setMaxAge(60 * 60);
        response.addCookie(cookie);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
