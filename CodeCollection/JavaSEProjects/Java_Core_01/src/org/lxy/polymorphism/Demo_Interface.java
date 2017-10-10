package org.lxy.polymorphism;
/**
 * @author menglanyingfei
 * @date 2017-2-14
 */
public class Demo_Interface {
	/**
	 * 接口的使用
	 * @param args
	 */
	public static void main(String[] args) {
		Dog1 d = new Dog1("二狗", 3);
		System.out.println(d.getName() + "|" + d.getAge());
		d.eat();
		System.out.println("=======================");
		JumpingDog jd = new JumpingDog("加狗特", 5);
		System.out.println(jd.getName() + "|" + jd.getAge());
		jd.eat();
		jd.jump();
	}
}

abstract class Animal1 extends Object {
	private String name;
	private int age;
	
	public Animal1() {}
	public Animal1(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	public abstract void eat();
}

interface Jumping {
	public static final int height = 160;
	
	public abstract void jump();
}

class Dog1 extends Animal1 {
	public Dog1() {}
	public Dog1(String name, int age) {
		super(name, age);
	}
	
	public void eat() {
		System.out.println("狗吃肉");
	}
}

class JumpingDog extends Dog1 implements Jumping {
	public JumpingDog() {}
	public JumpingDog(String name, int age) {
		super(name, age);
	}
	
	public void jump() {
		System.out.println("狗会跳");
	}
}

















