package com.lxy.dao;

import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.lxy.domain.Student;

/**
 * 操作XML（增删改查）
 * @author 15072
 *
 */
public class StuDao {
	/**
	 * 向student.xml中添加学生信息
	 * 部分bug：无法自动一直往根节点后添加子节点
	 * @throws Exception 
	 */
	public void addStu(Student stu) throws Exception {
		//操作XML，添加学生信息
		//1. 获取解析器对象
		SAXReader reader = new SAXReader();
		//2. 解析XML，返回Document对象
		Document document = reader.read("src/student.xml");		
		//3. 获取根节点
		Element root = document.getRootElement();
		
		root.addElement("student");
		Element student = (Element) root.elements("student").get(1);		
		student.addElement("num").setText(stu.getNum());
		student.addElement("name").setText(stu.getName());
		student.addElement("desc").setText(stu.getDesc());
		//回写
		OutputFormat format = OutputFormat.createPrettyPrint();
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/student.xml"), format);
		writer.write(document);
		writer.close();
	}
	
	/**
	 * 通过num删除学生信息
	 * @param num
	 */
	public void delStu(String num) {
		//删除学生信息	
	}
	
	/**
	 * 通过num修改学生信息
	 */
	public void updateStu(String num) {
		//修改学生信息
	}
	
	/**
	 * 通过num查询学生信息
	 * @param num
	 * @return
	 */
	public Student selStu(String num) {
		//修改学生信息		
		return null;
	}

}
