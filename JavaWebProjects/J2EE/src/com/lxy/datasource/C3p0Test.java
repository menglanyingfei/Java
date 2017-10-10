package com.lxy.datasource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author menglanyingfei
 * @date 2017-5-7
 */
public class C3p0Test {
	@Test
	public void test1() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass("com.mysql.jdbc.Driver");
		cpds.setJdbcUrl("jdbc:mysql:///mydb");
		cpds.setUser("root");
		cpds.setPassword("lxy");
		
		// 得到一个Connection
		Connection con = cpds.getConnection();
		
		ResultSet rs = con.createStatement().executeQuery("select * from account");
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("name"));
		}
		
		rs.close();
		con.close(); // 将Connection对象重新装入到连接池
	}
	
	@Test
	public void test2() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		// 得到一个Connection
		Connection con = cpds.getConnection();
		ResultSet rs = con.createStatement().executeQuery("select * from account");
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("name"));
		}
		
		rs.close();
		con.close(); // 将Connection对象重新装入到连接池
		
		String path = this.getClass().getResource("/").getPath();
		System.out.println(path);
	}
}













