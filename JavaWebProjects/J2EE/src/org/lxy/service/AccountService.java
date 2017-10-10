package org.lxy.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.lxy.dao._AccountDaoImpl;
import org.lxy.exception.AccountException;
import org.lxy.utils._JdbcUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-4
 */
public class AccountService {
	
	// 汇款方法
	/**
	 * 
	 * @param accountIn 收款人
	 * @param accountOut 汇款人
	 * @param money 金额
	 * @throws AccountException 
	 */
	public void account(String accountIn, String accountOut, double money) throws AccountException {
		// 在这个方法中要调用AccountDao中两个方法
		_AccountDaoImpl dao = new _AccountDaoImpl();
		
		Connection con = null;
		
		try {
			con = _JdbcUtils.getConnection();
			// 开启事务
			con.setAutoCommit(false);
			
			dao.accountOut(con, accountOut, money);
			dao.accountIn(con, accountIn, money);	
		} catch (Exception e) {
			e.printStackTrace();
			// 出现问题, 进行事务回滚
			if (con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			throw new AccountException(e.getMessage());
		}  finally {
			// 事务提交
			if (con != null) {
				try {
					con.commit();
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}


















