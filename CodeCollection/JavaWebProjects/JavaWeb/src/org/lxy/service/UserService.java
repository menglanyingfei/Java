package org.lxy.service;

import org.lxy.dao.UserDao;
import org.lxy.domain.User;
import org.lxy.exception.LoginException;

/**
 * @author menglanyingfei
 * @date 2017-4-27
 */
public class UserService {

	// service层的登录方法
	public User login(User user) throws LoginException {
		return new UserDao().findUser1(user);
	}

}
