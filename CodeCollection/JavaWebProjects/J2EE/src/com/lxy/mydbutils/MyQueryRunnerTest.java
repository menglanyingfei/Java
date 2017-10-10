package com.lxy.mydbutils;

import java.sql.SQLException;

import org.junit.Test;

import com.lxy.utils.DataSourceUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-9
 */
public class MyQueryRunnerTest {
	// 测试update方法
	@Test
	public void updateTest() throws SQLException {
		String sql = "delete from account where id=?";
		MyQueryRunner mqr = new MyQueryRunner();
		
		mqr.update(DataSourceUtils.getConnection(), sql, 3);
	}
}













