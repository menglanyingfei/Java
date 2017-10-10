package org.lxy.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author menglanyingfei
 * @date 2017-4-28
 */
public class _JdbcUtils {
	public static Connection getConnection() throws  SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///mydb";
		Connection con = DriverManager.getConnection(
		  url, "root", "lxy");
		
		return con;
	}
}













