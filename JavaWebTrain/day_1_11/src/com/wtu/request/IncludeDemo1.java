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
@WebServlet(name = "IncludeDemo1", value = "/IncludeDemo1")
public class IncludeDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // 响应内容
        response.getWriter().print("IncludeDemo响应内容");
        // 使用request对象向IncludeDemo2发起包含
        request.getRequestDispatcher("/IncludeDemo2").include(request, response);
    }
}
