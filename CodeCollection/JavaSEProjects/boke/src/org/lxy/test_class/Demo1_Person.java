package org.lxy.test_class;
/**
 * @author menglanyingfei
 * @date 2017-2-11
 */
public class Demo1_Person {
	public static void main(String[] args) {
		{
			System.out.println("我是局部代码块");
			int x = 10;					// 限定变量的生命周期
			System.out.println(x + "\n");
		}
		
		Person s1 = new Person();
		System.out.println("===============");
		Person s2 = new Person("小李", 20);
		System.out.println(s1.getName() + s2.getAge());
	}
}

class Person {
	private String name;
	private int age;
	
	public Person() {									// 空参构造
		System.out.println("我是空参构造方法");
	}							
	public Person(String name, int age) {	// 有参构造
		this.name = name;
		this.age = age;
		System.out.println("我是有参构造方法");
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

	{
		System.out.println("我是构造代码块");
	}
	
	static {
		System.out.println("我是静态代码块");
	}
}