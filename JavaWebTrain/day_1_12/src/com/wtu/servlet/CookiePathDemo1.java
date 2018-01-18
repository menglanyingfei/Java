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
@WebServlet(name = "CookiePathDemo1", value = "/servlet/CookiePathDemo1")
public class CookiePathDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建Cookie
        Cookie cookie = new Cookie("aaa", "AAA");

        response.addCookie(cookie);
    }
}
















