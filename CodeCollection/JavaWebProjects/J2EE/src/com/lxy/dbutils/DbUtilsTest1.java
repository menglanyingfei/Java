package com.lxy.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;
import org.lxy.utils.JdbcUtils;

import com.lxy.domain.Account;

/**
 * @author menglanyingfei
 * @date 2017-5-8
 */
public class DbUtilsTest1 {
	// 查询
	@Test
	public void selectTest_() throws SQLException {
		String sql = "select * from account";
		
		QueryRunner runner = new QueryRunner();
		List<Account> as = runner.query(JdbcUtils.getConnection(), sql, 
		  new BeanListHandler<Account>(Account.class));
		
		for (Account a : as) {
			System.out.println(a);
		}
	}
	
	// 改进版的查询
	@Test
	public void selectTest() throws SQLException {
		String sql = "select * from account where id=?";
		
		QueryRunner runner = new QueryRunner();
		
		List<Account> as = runner.query(JdbcUtils.getConnection(), sql, 
		  new ResultSetHandler<List<Account>>() {

			public List<Account> handle(ResultSet rs) throws SQLException {
				
				List<Account> as = new ArrayList<Account>();
				while (rs.next()) {
					Account a = new Account();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setMoney(rs.getDouble("money"));
					
					as.add(a);
				}
				
				return as;
			}
		}, 2);
		
		System.out.println(as);
		
	}
	
	// 添加
	@Test
	public void addTest() throws SQLException {
		String sql = "insert into account values(null, ?, ?)";
		QueryRunner runner = new QueryRunner();
		
		int row = runner.update(JdbcUtils.getConnection(), sql, "张三", 1000);
		
		System.out.println(row);
	}
}










