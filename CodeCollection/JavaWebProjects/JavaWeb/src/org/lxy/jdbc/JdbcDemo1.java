package org.lxy.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;


/**
 * @author menglanyingfei
 * @date 2017-4-20
 */
public class JdbcDemo1 {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// 1. 注册驱动
		DriverManager.registerDriver(new Driver());
		//Class.forName("com.mysql.jdbc.Driver");
		
		// 2. 获取连接对象
		//String url = "jdbc:mysql://localhost:3306/mydb";
		// 简写后
		String url = "jdbc:mysql:///mydb";
		Connection con = DriverManager.getConnection(
		  url, "root", "lxy");
		
		// 3. 通过连接对象获取操作SQL语句Statement
		Statement st = con.createStatement();
		
		// 4. 操作SQL语句
		String sql = "select * from user";
		
		// 操作SQL语句(select语句), 会得到一个ResultSet结果集
		ResultSet rs = st.executeQuery(sql);
		
		// 5. 遍历结果集
		while (rs.next()) {
			int id = rs.getInt("id");
			String username = rs.getString("username");
			String password = rs.getString("password");
			String email = rs.getString("email");
			
			System.out.println(id + " " + username + " " + password + " " + email);
		}
		
		// 6. 释放资源
		rs.close();
		st.close();
		con.close();
	}

}














