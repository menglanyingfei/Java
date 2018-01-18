package com.wtu.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/12.
 */
@WebServlet(name = "SessionDemo1", value = "/SessionDemo1")
public class SessionDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用session对象传输数据
        // 获取session对象
        HttpSession session = request.getSession();

        session.setAttribute("name", "中文");
        // 转发
        // 重定向
        response.sendRedirect(request.getContextPath() + "/jsp/sessionDemo1.jsp");
        System.out.println(request.getContextPath()); //           /day_1_12
    }
}
