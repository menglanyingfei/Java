package org.lxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * @author menglanyingfei
 * @date 2017-4-27
 */
// 使用配置文件
public class JdbcUtils {
	
	private static final String DRIVERCLASS;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;
	
	static {
		DRIVERCLASS = ResourceBundle.getBundle("jdbc").getString("driverClass");
		URL = ResourceBundle.getBundle("jdbc").getString("url");
		USERNAME = ResourceBundle.getBundle("jdbc").getString("username");
		PASSWORD = ResourceBundle.getBundle("jdbc").getString("password");
	}
	
	static {
		try {
			// 将加载驱动操作, 放置在静态代码块中, 这样就保证了只加载一次
			Class.forName(DRIVERCLASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() throws SQLException {
		// 获取连接
		Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		return con;
	}
	
	// 关闭操作
	public static void closeConnection(Connection con) throws SQLException {
		if (con != null) {
			con.close();
		}
	}
	
	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			st.close();
		}
	}
	
	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}
}



















