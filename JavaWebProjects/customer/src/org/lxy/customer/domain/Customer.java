package org.lxy.customer.domain;

import java.util.Date;

/**
 * @author menglanyingfei
 * @date 2017-5-11
 */
public class Customer {
	/*Id	编号	varchar(40)
	name	客户姓名	varchar(20)
	gender	性别	varchar(10)
	birthday	生日	date
	cellphone	手机	varchar(20)
	email	电子邮件	varchar(40)
	preference	客户爱好	varchar(100)
	type	客户类型	varchar(40)
	description	备注	varchar(255)*/
	
	private String id;
	private String name;
	private String gender;
	private Date birthday;
	private String cellphone;
	private String email;
	private String preference;
	private String type;
	private String description;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getCellphone() {
		return cellphone;
	}
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", gender=" + gender
				+ ", birthday=" + birthday + ", cellphone=" + cellphone
				+ ", email=" + email + ", preference=" + preference + ", type="
				+ type + ", description=" + description + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}







