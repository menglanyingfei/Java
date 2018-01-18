package com.wtu.image;

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
@WebServlet(name = "LoginServlet3", value = "/LoginServlet3")
public class LoginServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 编码
        request.setCharacterEncoding("utf-8");
        // 获取请求参数
        /*
            拿到页面传过来的手动输入的验证码, 该验证码要和生成图片上的
            文本验证码比较, 如果相同, 验证码输入成功!
         */
        String imageText = request.getParameter("image");
        // 图片的验证码
        String text = (String) request.getSession().getAttribute("text");

        if (!text.equalsIgnoreCase(imageText)) {
            request.setAttribute("imageMess", "验证码输入错误!");
            request.getRequestDispatcher("/jsp/login3.jsp").forward(request, response);
        }
        // 获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("haha".equals(username) && "123".equals(password)) {
            // 将用户信息保存到session中
            request.getSession().setAttribute("username", username);

            // 使用cookie实现回写用户名
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60 * 60);
            // 通过响应头发送cookie
            response.addCookie(cookie);
            // 重定向登录成功界面
            response.sendRedirect(request.getContextPath() + "/jsp/success2.jsp");
        } else {
            request.setAttribute("error", "用户名或密码错误!");
            request.getRequestDispatcher("/jsp/login3.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}










