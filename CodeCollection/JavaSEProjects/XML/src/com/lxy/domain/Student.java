package com.lxy.domain;
   
public class Student {
   
	private String num;
	private String name;
	private String desc;
	
	public Student() {
	}
	public Student(String num, String name, String desc) {
		this.num = num;
		this.name = name;
		this.desc = desc;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
  	
}
