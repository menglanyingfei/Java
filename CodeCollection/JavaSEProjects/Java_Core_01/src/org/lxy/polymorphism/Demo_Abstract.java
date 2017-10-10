package org.lxy.polymorphism;
/**
 * @author menglanyingfei
 * @date 2017-2-13
 */
public class Demo_Abstract {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new SuperMen();
		p.run();
	}
}

abstract class Person {
	public abstract void run();
}

class SuperMen extends Person {
	public void run() {
		System.out.println("超人跑步");
	}
}
















