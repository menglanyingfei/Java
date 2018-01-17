package com.wtu.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * jdbc工具类
 * @Author menglanyingfei
 * @Created on 2018.01.10 20:02
 */
public class JDBCUtils {
    public static Connection getConnection() {
        // 创建C3p0连接池对象
        ComboPooledDataSource ds = new ComboPooledDataSource();

        Connection conn;
        try {
            conn = ds.getConnection();
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
