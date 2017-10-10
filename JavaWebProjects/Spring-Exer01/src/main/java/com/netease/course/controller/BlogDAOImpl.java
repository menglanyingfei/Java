package com.netease.course.controller;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAOImpl implements BlogDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		if (this.jdbcTemplate == null)
			System.out.println("this.jdbcTemplate == null");
	}

	public void insertArticle(String title, String content) {
		if (this.jdbcTemplate == null)
			System.out.println("this.jdbcTemplate == null");
		Date datetime = new Date();
		this.jdbcTemplate
				.update("insert into Blog (blogTitle, blogContent ,nowDate) values (?,?,?)",
						title, content, datetime);
	}

	public void queryArticle() {
	}

	public int count() {
		System.out.println("query count");
		return 3;
	}
}
