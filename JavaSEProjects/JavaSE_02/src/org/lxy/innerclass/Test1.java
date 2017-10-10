package org.lxy.innerclass;

/**
 * @author menglanyingfei
 * @date 2017-5-25
 */
interface Vehicle {
	public void drive();
}

class Test1 {
	public static void main(String[] args) {
		// 父类引用指向子类对象, 匿名内部类
		Vehicle v = new Vehicle() {
			public void drive() {
				System.out.println("Driving a car!");
			}
		};
		v.drive();
	}
}