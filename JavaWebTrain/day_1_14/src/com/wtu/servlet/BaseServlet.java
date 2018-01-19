package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by menglanyingfei on 2018/1/14.
 */
@WebServlet(name = "BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求方法, 在请求参数中, 附带一个额外的参数, 该参数是一个方法名
        String methodName = req.getParameter("method");
        /*
        如果不通过反射来操作, 增加一个逻辑, 就需要修改代码!
        if ("addCustomer".equals(methodName)) {
            addCustomer(req, resp);
        } else if ("editCustomer".equals(methodName)) {
            editCustomer(req, resp);
        } else if ("findCustomer".equals(methodName)) {
            findCustomer(req, resp);
        } else if ("deleteCustomer".equals(methodName)) {
            deleteCustomer(req, resp);
        }
        */

        // 通过反射来实现(推荐)
        /*
            1. 获取方法名
            2. 获取当前类Class对象 this.getClass();
            3. 获取与该方法名对应的Method对象 getMethod(String name, Class<?>... parameterTypes)
                                                         方法名        方法的参数类型
            4. 通过Method对象来调用invoke(this, req, resp), 就相当于调用了methodName()
                假设获取的methodName为addCustomer
         */
        Class cl = this.getClass();
        Method method = null;

        try {
            method = cl.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            throw new RuntimeException("不能获取" + methodName + "Method对象");
        }

        String path = null;
        try {
            // 采用反射调用, 执行this.methodName(req, resp)的返回值
            path = (String) method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException("调用" + methodName + "出错!");
        }
        if (path == null) {
            System.out.println("什么也不做!!!");
            return;
        }
        // 在此处转发或重定向
        String[] arr = path.split(":");

        if ("redirect".equals(arr[0])) {
            resp.sendRedirect(req.getContextPath() + arr[1]);
        } else if ("forward".equals(arr[0])) {
            req.getRequestDispatcher(arr[1]).forward(req, resp);
        } else {
            throw new RuntimeException("操作有误，只能转发或者重定向，或者什么也不做");
        }
    }
}













