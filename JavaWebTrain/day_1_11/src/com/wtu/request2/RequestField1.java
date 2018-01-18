package com.wtu.request2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by menglanyingfei on 2018/1/11.
 */
@WebServlet(name = "RequestField1", value = "/RequestField1")
public class RequestField1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 往request域对象保存数据
        request.setAttribute("name", "哈哈");
        // 转发到requestField2中
//        request.getRequestDispatcher("/RequestField2").forward(request, response);

        response.sendRedirect("/day_1_11/RequestField2");
    }
}
