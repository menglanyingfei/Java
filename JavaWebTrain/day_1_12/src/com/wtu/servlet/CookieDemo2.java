package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "CookieDemo2", value = "/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 通过request对象获取Cookie
        Cookie[] cookies = request.getCookies();
        // 遍历数组
        for (Cookie cookie : cookies) {
            response.getWriter().print(cookie.getName() + " -- "
            + cookie.getValue());
        }
    }
}
