package org.lxy.dao;


/**
 * @author menglanyingfei
 * @date 2017-5-7
 */
public interface AccountDao {
	public void accountOut(String accountOut, double money) throws Exception;
	public void accountIn(String accountIn, double money) throws Exception;
	
}









