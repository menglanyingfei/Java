package org.lxy.javase;
/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class Student {
	private String name;
	private int age;
	
	public Student() {}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}	
}
