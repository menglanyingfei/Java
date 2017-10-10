package org.lxy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

/**
 * @author menglanyingfei
 * @date 2017-4-22
 */
public class JdbcDemo2_FindById {

	@Test
	public void findById() {
		// 定义sql语句
		String sql = "select * from user where id = 1";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2. 获取连接对象
			//String url = "jdbc:mysql://localhost:3306/mydb";
			// 简写后
			String url = "jdbc:mysql:///mydb";
			Connection con = DriverManager.getConnection(
			  url, "root", "lxy");
			
			// 3. 通过连接对象获取操作SQL语句Statement
			Statement st = con.createStatement();
			
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
			
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}














