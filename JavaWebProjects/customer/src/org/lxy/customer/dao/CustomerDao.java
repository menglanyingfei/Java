package org.lxy.customer.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.lxy.customer.domain.Customer;
import org.lxy.customer.utils.DataSourceUtils;

/**
 * @author menglanyingfei
 * @date 2017-5-11
 */
public class CustomerDao {
	// 查询所有客户
	public List<Customer> findAll() throws SQLException {
		String sql = "select * from customer";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
	}

	public void delById(String id) throws SQLException {
		String sql = "delete from customer where id = ?";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, id);
	}

	public Customer findById(String id) throws SQLException {
		String sql = "select * from customer where id = ?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		return runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
	}

	public void update(Customer c) throws SQLException {
		String sql = "update customer set name=?, gender=?, birthday=?, cellphone=?, email=?, preference=?, type=?, description=? where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		runner.update(sql, c.getName(), c.getGender(), c.getBirthday(), 
		  c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription(), c.getId());
		
	}

	public void add(Customer c) throws SQLException {
		String sql = "insert into customer values(?,?,?,?,?,?,?,?,?)";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		runner.update(sql, c.getId(), c.getName(), c.getGender(), c.getBirthday(), 
		   c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription());
				
	}

	public void delSelect(String[] id) throws SQLException {
		String sql = "delete from customer where id=?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		
		Object[][] ids = new Object[id.length][1];
		
		for (int i=0; i < id.length; i++) {
			ids[i][0] = id[i];
		}
		
		runner.batch(sql, ids);
	}
	// 条件查询
	// field 相当于字段名称
	// msg 相当于字段值
	public List<Customer> simpleSelect(String field, String msg) throws SQLException {
		String sql = "select * from customer where " + field +"  like ?";
		
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
				
		return runner.query(sql, new BeanListHandler<Customer>(Customer.class),  "%" + msg + "%");
	}

	// 分页操作
	/**
	 * 
	 * @param pageNum 页码
	 * @param currentPage 每页条数
	 * @throws SQLException 
	 */
	public List<Customer> findByPage(int pageNum, int currentPage) throws SQLException {
		String sql = "select * from customer limit ?,?";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());		
		return runner.query(sql, new BeanListHandler<Customer>(Customer.class), (pageNum - 1) * currentPage, currentPage);
	}

	// 查询总条数
	public int findAllCount() throws SQLException {
		String sql = "select count(*) from customer";
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		long count = (Long) runner.query(sql, new ScalarHandler());
		return (int) count;
	}
}










































