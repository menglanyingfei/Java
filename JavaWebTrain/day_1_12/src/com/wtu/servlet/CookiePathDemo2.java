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
@WebServlet(name = "CookiePathDemo2", value = "/CookiePathDemo2")
public class CookiePathDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if ("aaa".equals(cookie.getName())) {
                response.getWriter().print(cookie.getValue());
            } else{
                response.getWriter().print("没有该Cookie");
            }
        }
    }
}
