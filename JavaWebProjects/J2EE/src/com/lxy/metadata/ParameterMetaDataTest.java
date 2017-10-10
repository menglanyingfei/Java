package com.lxy.metadata;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lxy.utils.JdbcUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-8
 */
public class ParameterMetaDataTest {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		Connection con = JdbcUtils.getConnection();
		
		String sql = "select * from account where id=? and name=?";
		PreparedStatement pst = con.prepareStatement(sql);
		
		// 获取一个ParameterMetaData
		ParameterMetaData pmd = pst.getParameterMetaData();
		
		// 获取参数的个数
		int count = pmd.getParameterCount();
		System.out.println(count);
		
		String type = pmd.getParameterTypeName(1);
		System.out.println(type);
	}

}
