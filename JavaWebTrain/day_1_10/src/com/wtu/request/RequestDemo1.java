package com.wtu.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.10 16:13
 */
public class RequestDemo1 extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 解决响应乱码问题
        resp.setHeader("content-type","text/html;charset=UTF-8");
        // 这种方式只适合post方式提交的数据, 解决请求乱码
        req.setCharacterEncoding("utf-8");

        /*
        request对象的使用

        request对象:
            该对象封装了所有的请求信息
            1. 请求参数
                request.getParameter("表单中name属性的属性值")
                String[] getParameterValues(String name)
                获取请求参数, 但是参数值有多个
         */
        // 获取用户名
        String username = req.getParameter("username");
        String password = req.getParameter("password");
//        String sex = req.getParameter("sex");
//        String[] hobby = req.getParameterValues("hobby");
//        String birthday = req.getParameter("birthday");

        resp.getWriter().print(username);
        resp.getWriter().print(password);
//        resp.getWriter().print(sex);
//        resp.getWriter().print(Arrays.toString(hobby));
//        resp.getWriter().print(birthday);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
