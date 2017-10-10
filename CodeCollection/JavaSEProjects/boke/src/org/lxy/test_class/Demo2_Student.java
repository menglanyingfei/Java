package org.lxy.test_class;
/**
 * @author menglanyingfei
 * @date 2017-2-11
 */
public class Demo2_Student {
	static {
		System.out.println("Demo2_Student主类中 静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("Demo2_Student主类中 main方法");
		System.out.println("==========================");
		Student s1 = new Student();
		Student s2 = new Student();
		System.out.println(s1.toString() + s2.toString());
	}
}

class Student {
	static {
		System.out.println("Student类中 静态代码块");
	}
	
	{
		System.out.println("Student类中 构造代码块");
	}
	
	public Student() {
		System.out.println("Student类中 构造方法");
	}
}