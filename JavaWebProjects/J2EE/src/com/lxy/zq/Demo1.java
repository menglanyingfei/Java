package com.lxy.zq;
/**
 * @author menglanyingfei
 * @date 2017-5-7
 */
// 使用继承增强
public class Demo1 {
	
	public static void main(String[] args) {
		Person1 p = new Student1();
		p.eat();
	}
}

class Person1 {
	public void eat() {
		System.out.println("吃两个馒头");
	}
}

class Student1 extends Person1 {
	@Override
	public void eat() {	
		super.eat();
		System.out.println("加两个鸡腿");
	}
}








