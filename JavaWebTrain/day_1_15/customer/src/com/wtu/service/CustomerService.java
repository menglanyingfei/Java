package com.wtu.service;

import java.util.List;

import com.wtu.dao.CustomerDao;
import com.wtu.entity.Customer;
import com.wtu.entity.PageBean;


public class CustomerService {
	
	private CustomerDao customerDao = new CustomerDao();
	
	public void addCustomer(Customer customer) throws Exception{
		customerDao.addCustomer(customer);
	}
	
	public void editCustomer(Customer customer) throws Exception{
		customerDao.editCustomer(customer);
	}
	
	
	public PageBean<Customer> findAllCustomer(PageBean pageBean) throws Exception{
		return customerDao.findAllCustomer(pageBean);
	}

	public PageBean<Customer> query(Customer customer, Integer cp, Integer pr) throws Exception {
		
		return customerDao.query(customer,cp,pr);
	}

	/**
	 * 根据id查询客户信息
	 * @param cid
	 * @return
	 * @throws Exception 
	 */
	public Customer findCustomerById(String cid) throws Exception {
		return customerDao.findCustomerById(cid);
	}

	public void deleteCustomerById(String cid) throws Exception{
		customerDao.deleteCustomerById(cid);
	}
}
