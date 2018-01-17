package com.wtu.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.10 10:13
 */
public class ServletDemo2 extends ServletDemo1 {
    /*
        以后只要重写该方法即可
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /*
            servlet处理具体请求的方法
            处理请求, 每请求一次, 就会调用一次该方法
         */
        System.out.println("service2...");

    }
}
