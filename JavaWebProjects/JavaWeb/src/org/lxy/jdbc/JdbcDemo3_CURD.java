package org.lxy.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.lxy.jdbcutils.JdbcUtils1;
import org.lxy.utils.JdbcUtils;

/**
 * @author menglanyingfei
 * @date 2017-4-28
 */
public class JdbcDemo3_CURD {
	// 添加操作
	@Test
	public void addTest() {
		// 定义SQL
		String sql = "insert into user values(null, '张三', '123', 'zs@163.com')";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");		
			String url = "jdbc:mysql:///mydb";
			con = DriverManager.getConnection(
			  url, "root", "lxy");
			
			// 3. 通过连接对象获取操作SQL语句Statement
			st = con.createStatement();
			
			// 执行SQL
			int row = st.executeUpdate(sql);
			
			if (row != 0) {
				System.out.println("添加成功");
			}				
		} catch (ClassNotFoundException e) {	
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
	}
	
	// update操作
	@Test
	public void updateTest() {
		// 将id=3的人的password修改为456
		String password = "456";
		// String sql = "update user set password = '456' where id = 3";
		String sql = "update user set password = '" + password + "' where id = 3";
		
		// 1.得到Connection
		Connection con = null;
		Statement st = null;
		try {
			con = JdbcUtils1.getConnection();
			// 3. 通过连接对象获取操作SQL语句Statement
			 st = con.createStatement();
					
			int row = st.executeUpdate(sql);
			
			if (row != 0) {
				System.out.println("修改成功");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}		
		}
	}
	
	// delete测试
	@Test
	public void deleteTest() {
		// 将id=3的人删除
			String sql = "delete from user where id = 3";	
			// 1.得到Connection
			Connection con = null;
			Statement st = null;
			try {
				con = JdbcUtils.getConnection();
				// 3. 通过连接对象获取操作SQL语句Statement
				 st = con.createStatement();
						
				int row = st.executeUpdate(sql);
				
				if (row != 0) {
					System.out.println("删除成功");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				// 关闭资源
				try {
					JdbcUtils.closeConnection(con);
					JdbcUtils.closeStatement(st);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			}
	}
}




















