package com.lxy.basic;
/**
 * @author menglanyingfei
 * @date 2017-2-11
 */
public class Main08_PalindromeNumber {
	/**
	 * 四位的回文数 1221
	 * @param args
	 * 10min
	 * 1
	 */
	public static void main(String[] args) {
		int a, b, c, d;
		for (int i = 1000; i < 10000; i++) {
			a = i / 1000;
			b = i / 100 % 10;
			c = i / 10 % 10;
			d = i % 10;
			if (a == d && b == c) {
				System.out.println(i);
			}
		}
	}

}
