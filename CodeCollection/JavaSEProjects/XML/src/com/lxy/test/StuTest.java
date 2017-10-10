package com.lxy.test;

import com.lxy.dao.StuDao;
import com.lxy.domain.Student;

public class StuTest {
	
	public static void main(String[] args)  {
		Student stu = new Student("002", "张三", "也爱学习");
		StuDao dao = new StuDao();		
		try {
			dao.addStu(stu);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
