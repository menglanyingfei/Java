package org.lxy.innerclass;

/**
 * @author menglanyingfei
 * @date 2017-5-25
 */

public class Car {
	
	public void drive() {
		System.out.println("Driving a car!");
	}

	public static void main(String[] args) {
		Car car = new Car() {
			public void drive() {
				System.out.println("Driving another car!");
			}
		};
		car.drive();
	}
}
