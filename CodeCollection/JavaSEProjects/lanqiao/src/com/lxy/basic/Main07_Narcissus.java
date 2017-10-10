package com.lxy.basic;
/**
 * @author menglanyingfei
 * @date 2017-2-11
 */
public class Main07_Narcissus {
	/**
	 * 水仙花数的求解
	 * 153
	 * @param args
	 * 时间: 10min
	 * 次数: 1次
	 */
	public static void main(String[] args) {
		int a, b, c;	
		for (int n = 100; n < 1000; n++) {
			a = n / 100;
			b = n / 10 % 10;
			c = n % 10;
			if (n == a*a*a + b*b*b + c*c*c) {
				System.out.println(n);
			}
		}
	}
}
