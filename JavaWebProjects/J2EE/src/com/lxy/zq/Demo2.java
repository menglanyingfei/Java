package com.lxy.zq;
/**
 * @author menglanyingfei
 * @date 2017-5-7
 */
// 使用装饰进行增强
public class Demo2 {
	public static void main(String[] args) {
		Car car = new Bmw();
		
		// 给车增强
		CarDetector cd = new CarDetector(car);
		
		cd.run();
	}
}

interface Car {
	void run();
}

class Bmw implements Car {
	public void run() {
		System.out.println("bmw run...");
	}
}

class Benz implements Car {

	public void run() {
		System.out.println("benz run...");
	}
	
}

// 使用装饰来完成
class CarDetector implements Car {
	private Car car;
	public CarDetector(Car car) {
		this.car = car;
	}
	public void run() {
		System.out.println("添加导航");
		car.run();
	}
	
}






