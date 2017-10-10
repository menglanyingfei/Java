package com.netease.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netease.course.dao.UserDao;
import com.netease.course.entity.User;
import com.netease.course.service.userAccountService;

@Service
public class UserAccountValidateService implements userAccountService {
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		System.out.println("userdao init");
		this.userDao = userDao;
	}

	@Override
	public User findUserByAccount(String username) {
		if (username.equals(null) || username == "") {
			return null;
		}
		System.out.println(userDao);
		return userDao.select(username);
	}

	@Override
	public String toString() {
		return "UserAccountValidateService [userDao=" + userDao + "]";
	}

}
