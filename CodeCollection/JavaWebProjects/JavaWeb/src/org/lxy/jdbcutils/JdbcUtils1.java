package org.lxy.jdbcutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author menglanyingfei
 * @date 2017-4-28
 */
public class JdbcUtils1 {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql:///mydb";
		Connection con = DriverManager.getConnection(
		  url, "root", "lxy");
		
		return con;
	}
}













