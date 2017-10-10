package com.netease.course;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author menglanyingfei
 * @date 2017-8-22
 */

@Repository
public class JdbcTemplateDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void createTable() {
		jdbcTemplate
				.execute("create table user (id integer, first_name varchar(100), last_name varchar(100))");
	}

	public void insertData() {
		this.jdbcTemplate.update("insert into user values (1, ?, ?)", "Meimie",
				"Han");
		this.jdbcTemplate.update("insert into user values (2, ?, ?)", "Lei",
				"Li");
	}

	public int count() {
		return this.jdbcTemplate.queryForObject("select count(*) from user",
				Integer.class);
	}

	public List<User> getUserList() {
		return this.jdbcTemplate.query("select * from user",
				new RowMapper<User>() {

					@Override
					public User mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setFirstName(rs.getString("first_name"));
						user.setLastName(rs.getString("last_name"));

						return user;
					}

				});
	}
}
