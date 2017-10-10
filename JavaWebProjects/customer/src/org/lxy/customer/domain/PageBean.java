package org.lxy.customer.domain;

import java.util.List;

/**
 * @author menglanyingfei
 * @date 2017-5-15
 */
public class PageBean {
	
	private int pageNum; // 页码
	private int currentPage; // 每页条数
	private int totalPage; // 总页数
	private int totalCount; // 总条数
	private List<Customer> cs; // 每页数据
	
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<Customer> getCs() {
		return cs;
	}
	public void setCs(List<Customer> cs) {
		this.cs = cs;
	}
	
}














