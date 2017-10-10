package org.lxy.customer.service;

import java.sql.SQLException;
import java.util.List;

import org.lxy.customer.dao.CustomerDao;
import org.lxy.customer.domain.Customer;
import org.lxy.customer.domain.PageBean;

/**
 * @author menglanyingfei
 * @date 2017-5-11
 */
public class CustomerService {
	
	private CustomerDao dao = new CustomerDao();
	
	// 查询所有客户信息操作
	public List<Customer> findAll() throws SQLException {
		
		return dao.findAll();
	}

	// 根据id删除
	public void delById(String id) throws SQLException {
		dao.delById(id);
	}
	// 根据id删除
	public Customer findById(String id) throws SQLException {
		
		return dao.findById(id);
	}
	// 修改客户信息
	public void update(Customer c) throws SQLException {
		dao.update(c);
	}
	// 添加客户信息
	public void add(Customer c) throws SQLException {
		dao.add(c);
	}
	// 批量删除
	public void delSelect(String[] id) throws SQLException {
		dao.delSelect(id);
	}
	// 条件查询
	public List<Customer> simpleSelect(String field, String msg) throws SQLException {
		return dao.simpleSelect(field, msg);
	}
	// 分页操作
	/**
	 * 
	 * @param pageNum 页码
	 * @param currentPage 每页条数
	 * @throws SQLException 
	 */
	public PageBean findByPage(int pageNum, int currentPage) throws SQLException {
		
		PageBean pb = new PageBean();
		
		List<Customer> cs = dao.findByPage(pageNum, currentPage);
		
		// 查询总条数
		int totalCount = dao.findAllCount();
		
		// 得到总页数
		int totalPage = (int) Math.ceil(totalCount * 1.0 / currentPage);
		
		pb.setTotalCount(totalCount); // 封装总条数
		pb.setTotalPage(totalPage); // 封装总页数
		pb.setCs(cs); // 封装当前页数据
		pb.setCurrentPage(currentPage); // 封装每页条数
		pb.setPageNum(pageNum); // 封装当前页码
		
		return pb;
	}

}













