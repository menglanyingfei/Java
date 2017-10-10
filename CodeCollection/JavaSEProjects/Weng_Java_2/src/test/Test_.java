package test;

/**
 * @author menglanyingfei
 * @date 2017-8-16
 */

class Base {
	/*
	private Base() {
		System.out.println(0);
	}
	*/
	
	public Base(int i) {
		System.out.println(i);
	}
}

public class Test_ extends Base {
	public Test_() {
		super(1);
	};

	public static void main(String argv[]) {
		//Test_ t = new Test_();
	}
}
