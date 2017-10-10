package com.netease.course.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.netease.course.dao.UserDao;
import com.netease.course.meta.User;
import com.netease.course.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public List<User> getUserList() {
		return userDao.getUserList();
	}
}
