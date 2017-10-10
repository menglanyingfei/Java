package org.lxy.polymorphism;
/**
 * @author menglanyingfei
 * @date 2017-2-13
 */
public class Test {
	/**
	 * 多态的使用
	 * @param args
	 */
	public static void main(String[] args) {
		method(new Dog());
	}
	
	public static void method(Animal a) {
		a.eat();
		Dog d = (Dog) a;
		System.out.println(a.age);
		d.eat();
		System.out.println(d.age);
	}
}

class Dog extends Animal {
	int age = 20;
	
	public void eat() {
		System.out.println("狗吃饭");		
	}
}

class Animal {
	int age = 10;
	
	public void eat() {
		System.out.println("动物吃饭");
	}
}