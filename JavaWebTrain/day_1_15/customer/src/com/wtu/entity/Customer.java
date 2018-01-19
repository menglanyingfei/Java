package com.wtu.entity;

import java.util.Date;

public class Customer {
	private String cid;
	private String cname;
	private String gender;
	private Date birthday;
	private String cellPhone;
	private String email;
	private String description;
	
	public Customer(String cid, String cname, String gender, Date birthday,
			String cellPhone, String email, String description) {
		this.cid = cid;
		this.cname = cname;
		this.gender = gender;
		this.birthday = birthday;
		this.cellPhone = cellPhone;
		this.email = email;
		this.description = description;
	}
	public Customer() {
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", gender="
				+ gender + ", birthday=" + birthday + ", cellPhone="
				+ cellPhone + ", email=" + email + ", description="
				+ description + "]";
	}
}
