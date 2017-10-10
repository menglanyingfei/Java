package org.lxy.customer.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author menglanyingfei
 * @date 2017-5-9
 */
public class DataSourceUtils {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	public static Connection getConnection() throws SQLException {
		return cpds.getConnection();
	}
	
	public static DataSource getDataSource() {
		return cpds;
	}
}
