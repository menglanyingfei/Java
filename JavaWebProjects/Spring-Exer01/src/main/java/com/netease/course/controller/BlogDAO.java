package com.netease.course.controller;

public interface BlogDAO {
	public void insertArticle(String title, String content);

	public int count();
}
