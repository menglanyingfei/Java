package org.lxy.service;

import java.sql.SQLException;

import org.lxy.dao.UserDao;
import org.lxy.domain.User;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class UserService {

	public User login(String username, String password) throws SQLException {
		
		return new UserDao().findByUsernameAndPassword(username, password);
	}

}


















