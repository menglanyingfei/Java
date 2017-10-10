package com.netease.course.service;

import org.springframework.stereotype.Component;

/**
 * @author menglanyingfei
 * @date 2017-8-26
 */

@Component
public class UserService {

	public void add(String username) throws Exception {
		System.out.println("添加用户:" + username);
		throw new Exception("测试");
	}

	public void edit(String username) {
		System.out.println("修改用户:" + username);
	}

	public void del(String username) {
		System.out.println("删除用户:" + username);
	}

	public void find(String username) {
		System.out.println("查询用户:" + username);
	}
}
