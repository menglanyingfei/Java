package com.wtu.servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by menglanyingfei on 2018/1/10.
 */
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
         * 1.如何获得ServletContext对象
		 *   a.ServletConfig  提供的方法  getServletContext();
		 *   b.通过集成的GenericServlet中提供的  getServletContext();
		 *   c.通过 request的   getServletContext();
		 *
		 * 2.ServletContext 常用方法的使用：
		 *   a.用来获取全局的初始化参数
		 *      getInitParameter(String name); 根据参数名  获取参数值
				getInitParameterNames() ;       获取所有的参数名
		 *   b.作为域对象的方法。
		 *
		 *   c:获取资源文件的相关信息:
		 *     getRealPath(String path)  获取某个资源文件的真实路径 参数是该文件相对于项目的路径
		 *     getResourceAsStream(String path)  获取某个资源文件的输入流  参数是该文件相对于项目的路径
		 */

        //获取ServletContext对象
        ServletContext application = this.getServletContext();

        System.out.println(application.getInitParameter("haha"));

        //获取index.jsp文件的真实路径
        String realPath = application.getRealPath("/index.jsp");
        System.out.println(realPath);
        //E:\repository\Java\JavaWebTrain\day_1_10\out\artifacts\web_war_exploded\index.jsp
        //获取index.jsp的输入流对象
        InputStream in = application.getResourceAsStream("/index.jsp");

        //定义缓冲数组
        byte[] by = new byte[1024];
        int l = 0;
        while ((l = in.read(by)) != -1) {
            System.out.println(Arrays.toString(by));
        }

        response.getWriter().print(in);
        //java.io.ByteArrayInputStream@641aab7c
    }
}
