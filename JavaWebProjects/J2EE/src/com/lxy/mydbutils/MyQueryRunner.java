package com.lxy.mydbutils;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 * @author menglanyingfei
 * @date 2017-5-9
 */
public class MyQueryRunner {
	private DataSource ds;
	
	public MyQueryRunner() {
		super();
	}
	public MyQueryRunner(DataSource ds) {
		this.ds = ds;
	}
	// 执行select操作
	public Object query() {
		return null;
	}
	
	// 执行update操作
	public int update(Connection con, String sql, Object... params) throws SQLException {
		// 得到一个预处理的Statement
		PreparedStatement pst = con.prepareStatement(sql);
		// 问题: sql语句中可能存在参数, 需要对参数赋值
		
		ParameterMetaData pmd = pst.getParameterMetaData();
		// 可以得到有几个参数
		int count = pmd.getParameterCount();
		for (int i = 1; i <= count; i++) {
			pst.setObject(i, params[i - 1]);
		}
		
		int row = pst.executeUpdate();
		// 关闭资源
		pst.close();
		return row;
	}
	
	public int update(String sql, Object... params) throws SQLException {
		Connection con = ds.getConnection();
		// 得到一个预处理的Statement
		PreparedStatement pst = con.prepareStatement(sql);
		// 问题: sql语句中可能存在参数, 需要对参数赋值
		
		ParameterMetaData pmd = pst.getParameterMetaData();
		// 可以得到有几个参数
		int count = pmd.getParameterCount();
		for (int i = 1; i <= count; i++) {
			pst.setObject(i, params[i - 1]);
		}
		
		int row = pst.executeUpdate();
		// 关闭资源
		pst.close();
		con.close();
		return row;
	}
}












