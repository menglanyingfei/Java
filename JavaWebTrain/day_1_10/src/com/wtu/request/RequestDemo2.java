package com.wtu.request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by menglanyingfei on 2018/1/10.
 */
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            request对象获取请求参数
            Map<String, String[]> getParameterMap()
                得到很多个键值对
                键: 表单中, name属性的属性值 value: 对应的参数值
                Enumeration<String> getParameterNames()
         */
        response.setContentType("text/html;charset=utf-8");
        // 这种方式只适合post方式提交的数据, 解决请求乱码
        request.setCharacterEncoding("utf-8");

        // 获取用户名
        Map<String, String[]> usernameMap = request.getParameterMap();
//        response.getWriter().print(usernameMap);
        System.out.println(usernameMap);

        // 获取所有参数的名称
        Enumeration<String> names = request.getParameterNames();
        while (names.hasMoreElements()) {
            String string = names.nextElement();
            response.getWriter().print(string + " ");
        }

        // 遍历该Map集合, 采用EntrySet
        for (Map.Entry<String, String[]> entry : usernameMap.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
//            System.out.println(key + "--" + Arrays.toString(values));
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}








