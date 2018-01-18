package com.wtu.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by menglanyingfei on 2018/1/11.
 */
public class ServletDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        // 通过response对象获取字符流
//        PrintWriter pw = response.getWriter();
        // 向浏览器输出打印
//        pw.print("<h1>123</h1>");

        // 通过response对象获取字节流
        OutputStream out = response.getOutputStream();

        // 用本地磁盘图片来创建输入流对象
        InputStream in = new FileInputStream("E:\\repository\\Java\\JavaWebTrain\\day_1_11\\data\\1.txt");
        // 复制
        IOUtils.copy(in, out);

    }
}
