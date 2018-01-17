package com.wtu.c3p0;

import java.sql.Connection;

/**
 * @Author menglanyingfei
 * @Created on 2018.01.10 19:58
 */
public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        // 加载驱动(注册驱动)
        /*
        Class.forName("com.mysql.jdbc.Driver");

        Connection conn = DriverManager.getConnection("", "", "");

        conn.close();
        */
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
        //com.mchange.v2.c3p0.impl.NewProxyConnection@71bc1ae4
    }
}




