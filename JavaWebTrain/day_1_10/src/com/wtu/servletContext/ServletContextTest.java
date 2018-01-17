package com.wtu.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 解决响应乱码问题
 * Created by menglanyingfei on 2018/1/10.
 */
public class ServletContextTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            统计网站的访问次数:
            1. 定义一个整数 用来保存访问次数
            并且将该整数保存到ServletContext中

            2. 如果是第一次访问, 那么没有这个参数, 此时, 创建一个参数, 赋值为1
              直接从ServletContext获取该参数的值, 如果没有改参数, 那么返回的是NULL

            3. 将该参数打印到页面显示

         */
        // 解决响应乱码问题
        response.setHeader("content-type","text/html;charset=UTF-8");
        // 获取ServletContext对象
        ServletContext application = this.getServletContext();
        // 从application中获取, 是否有一个参数, 用来统计访问次数
        Integer count = (Integer) application.getAttribute("count");

        if (count == null) {
            application.setAttribute("count", 1);
        } else {
            application.setAttribute("count", count + 1);
        }

        count = (Integer) application.getAttribute("count");
        // 输出
        PrintWriter pw = response.getWriter();
        pw.print("<html");
        pw.print("<head>");
        pw.print("<title>");
        pw.print("统计次数");
        pw.print("</title>");
        pw.print("</head>");
        pw.print("<body>");
        pw.print("<h1>一共被访问了" + count + "次</h1>");
        pw.print("</body>");

        pw.print("</html>");
    }
}














