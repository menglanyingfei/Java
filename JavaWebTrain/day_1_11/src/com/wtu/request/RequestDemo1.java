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
@WebServlet(name = "RequestDemo1", value = "/RequestDemo1")
public class RequestDemo1 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(request.getContextPath());
        response.getWriter().println(request.getMethod());
        response.getWriter().println(request.getQueryString());
        response.getWriter().println(request.getRequestURI());
        response.getWriter().println(request.getRequestURL());
        response.getWriter().println(request.getServletPath());

        response.getWriter().println(request.getServerName()); // localhost
        response.getWriter().println(request.getRemoteAddr());
        response.getWriter().println(request.getRemoteHost());
        response.getWriter().println(request.getRemotePort());
        response.getWriter().println(request.getScheme());
        response.getWriter().println(request.getCharacterEncoding());
        
        response.getWriter().println("\n abc hello");
        
    }
}
