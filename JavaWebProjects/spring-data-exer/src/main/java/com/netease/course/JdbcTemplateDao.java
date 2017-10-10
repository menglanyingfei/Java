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
 * @date 2017-8-27
 */

/**
 * 
 * @author 15072 使用Spring JDBC
 */
@Repository
public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void resetMoney() {
		jdbcTemplate.update("update UserBalance set balance=1000");
	}

	// 加上传播行为, 使用Annotation的方式添加事务
	@Transactional(propagation = Propagation.REQUIRED)
	public void transferMoney(Long srcUserId, Long targetUserId, double count) {
		this.jdbcTemplate.update(
				"update UserBalance set balance=balance-? where userId=?",
				count, srcUserId);
		this.jdbcTemplate.update(
				"update UserBalance set balance=balance+? where userId=?", count,
				targetUserId);
	}

	public List<UserBalance> userBalanceList() {
		return this.jdbcTemplate.query("select * from UserBalance",
				new RowMapper<UserBalance>() {

					public UserBalance mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						UserBalance userBalance = new UserBalance();
						userBalance.setUserId(rs.getLong("userId"));
						userBalance.setBalance(rs.getDouble("balance"));

						return userBalance;
					}

				});
	}
}
