package com.netease.course.service;

import com.netease.course.entity.User;

public interface userAccountService {
	public User findUserByAccount(String username);
}
