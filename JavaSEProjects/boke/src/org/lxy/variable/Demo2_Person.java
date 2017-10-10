package org.lxy.variable;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Demo2_Person {
	public static void main(String[] args) {
		Person p = new Person();
		p.speak();
		p.talk(6);
	}
}

class Person {
	String name;								// 成员变量
	int num;									// 其默认初始化值为0
	
	public void speak() {				
		int num = 10;						// num和下面的x都是局部变量
		System.out.println(name);		// null
		System.out.println(num);		// 10
	}
	public void talk(int x) {	
		System.out.println(num);		// 0
	}
}