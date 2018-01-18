package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "CookieTest2", value = "/CookieTest2")
public class CookieTest2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 获取上次访问的时间
        String message = "你是第一次访问该网站";
        Date date = new Date();

//        String time = date.toLocaleString();
        String time = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(date);
        Cookie c = new Cookie("time", time);
        c.setMaxAge(60 * 60);
        response.addCookie(c);

        // 获取cookie
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("time".equals(cookie.getName())) {
                    message = "您上次访问该网站的时间是" + cookie.getValue();

                }
            }

        }

        response.getWriter().print(message);
    }
}














