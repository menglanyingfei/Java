package com.netease.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author menglanyingfei
 * @date 2017-8-22
 */

@Repository
public class AccountDao {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void resetMoney() {
		jdbcTemplate.update("update account set balance=1000");
	}
	
	public List<UserBalance> accountList() {
		return this.jdbcTemplate.query("select * from account", new RowMapper<UserBalance>() {

			public UserBalance mapRow(ResultSet rs, int rowNum) throws SQLException {
				UserBalance account = new UserBalance();
				account.setUser(rs.getString("user"));
				account.setBalance(rs.getDouble("balance"));
				
				return account;
			}
			
		});
	}
	
	// 加上传播行为
	@Transactional(propagation=Propagation.REQUIRED)
	public void transferMoney(String source, String target, double count) {
		this.jdbcTemplate.update("update account set balance=balance-? where user=?", count, source);
		throwException();
		this.jdbcTemplate.update("update account set balance=balance+? where user=?", count, target);
	}
	
	private void throwException() {
		throw new RuntimeException("ERROR");
	}
}	








