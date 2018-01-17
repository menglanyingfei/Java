package com.wtu.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * Servlet
 * 单例多线程
 *
 * 问题: 我们实现Servlet接口时, 每次都需要实现多个方法, 有点麻烦!
 * 所以, 直接继承HttpServlet
 * @Author menglanyingfei
 * @Created on 2018.01.10 9:42
 */
public class ServletDemo1 extends HttpServlet {

    /*
       Servlet的方法:
       是生命周期的方法之一
    */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        // 当请求到达服务器的时候, 服务器马上实例化servlet对象
        // 并且调用该方法 初始化Servlet, 在Servlet生命周期只创建一次
        System.out.println("初始化");
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
            servlet处理具体请求的方法
            处理请求, 每请求一次, 就会调用一次该方法
         */
        System.out.println("service");
    }
    @Override
    public void destroy() {
        /*
         * 在服务器关闭前的时候执行的方法 销毁Servlet实例
         */
        System.out.println("销毁!");
    }
}
