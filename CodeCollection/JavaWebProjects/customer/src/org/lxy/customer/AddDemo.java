package org.lxy.customer;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.lxy.customer.utils.DataSourceUtils;
import org.lxy.customer.utils.IdUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-16
 */
public class AddDemo {

	@Test
	public void add() throws SQLException {
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		for (int i = 0; i < 10; i++) {
			runner.update("insert into customer(id) values(?)", IdUtils.getUUID());
		}
	}
}
