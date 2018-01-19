package com.wtu.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by menglanyingfei on 2018/1/14.
 */
@WebServlet(name = "CustomerServlet", value = "/CustomerServlet")
public class CustomerServlet extends BaseServlet {

    public void deleteCustomer(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("删除用户！！！！！");
    }

    public String addCustomer(HttpServletRequest req, HttpServletResponse resp) throws Exception {
//        resp.sendRedirect(req.getContextPath() + "/index.jsp");
//        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        System.out.println("添加用户");

        // 在这里返回一个路径
//        return "redirect:/index.jsp";
        return "forward:/index.jsp";
//        return null;
    }

    public void editCustomer(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("修改用户！！！");
    }

    public void findCustomer(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("查询用户！！");
    }
}
