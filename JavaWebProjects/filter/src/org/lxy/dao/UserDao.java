package org.lxy.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lxy.domain.User;
import org.lxy.utils.DataSourceUtils;
import org.lxy.utils.Md5Utils;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class UserDao {
	
	// 根据用户名与密码查找用户
	public User findByUsernameAndPassword(String username, String password) throws SQLException {
		String sql = "select * from user where username=? and password=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<User>(User.class), username, Md5Utils.md5(password));
	}

}
