package org.lxy.parameter_transfer;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Test3_Array {
	/**
	 * 基本数据类型的值传递
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		System.out.println("a:"+a+", b:"+b);		// a = 10, b = 20
		change(a, b);
		System.out.println("a:"+a+", b:"+b);		// a = 10, b = 20(结果不变)
	}

	public static void change(int a, int b) {	
		System.out.println("a:"+a+", b:"+b);		// a = 10, b = 20
		a = b;
		b = a + b;
		System.out.println("a:"+a+", b:"+b);		// a = 20, b = 40
	}
}
