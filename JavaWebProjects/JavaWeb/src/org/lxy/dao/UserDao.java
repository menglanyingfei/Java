package org.lxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.lxy.domain.User;
import org.lxy.exception.LoginException;
import org.lxy.utils.JdbcUtils;

/**
 * @author menglanyingfei
 * @date 2017-4-27
 */
public class UserDao {

	// 查找用户
	public User findUser1(User user) throws LoginException {
		// 1. SQL语句
		String sql = "select * from user where username='" + user.getUsername() + "' and password = '" + user.getPassword() + "'";
		
		// 2. 执行SQL
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sql);
			
			if (rs.next()) { // 如果可以next, 代表查找到了这个用户的信息, 就将结果集中的信息封装到User对象中
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败:原因" + e.getMessage());
		}
		return null;
	}

	// 查找用户
	// 使用PreparedStatement来完成操作, 它可以解决SQL注入
	public User findUser(User user) throws LoginException {
		// 1. SQL语句
		String sql = "select * from user  where username = ? and password = ?";
		
		// 2. 执行SQL
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtils.getConnection();
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getUsername());
			pst.setString(2, user.getPassword());
			
			rs = pst.executeQuery(); // 无参数
			
			if (rs.next()) { // 如果可以next, 代表查找到了这个用户的信息, 就将结果集中的信息封装到User对象中
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				return u;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new LoginException("登录失败:原因" + e.getMessage());
		}
		return null;
	}
}





















