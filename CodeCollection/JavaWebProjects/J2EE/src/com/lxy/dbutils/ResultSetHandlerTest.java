package com.lxy.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.junit.Test;

import com.lxy.domain.Account;
import com.lxy.utils.DataSourceUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-9
 */
public class ResultSetHandlerTest {
	
	// 将结果封装到一个JavaBean
	@Test
	public void fun1() throws SQLException {
		String sql = "select * from account where id=?";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		Account a = runner.query(sql, new ResultSetHandler<Account>() {
			public Account handle(ResultSet rs) throws SQLException {
				Account a = null;
				
				if (rs.next()) {
					a = new Account();
					a.setId(rs.getInt("id"));
					a.setName(rs.getString("name"));
					a.setMoney(rs.getDouble("money"));
				}
				
				return a;
			}
		}, 2);
		
		System.out.println(a);
		
	}
}









