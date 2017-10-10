package com.lxy.learning;
/**
 * @author menglanyingfei
 * @date 2017-2-18
 */
public class Print0_9 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}*/
//		f(9);
		f(0, 9);	
	}

	private static void f(int begin, int end) {
		if (begin > end) {
			return;
		}
		f(begin, end - 1);
		System.out.println(end);
	}

	/*private static void f(int n) {
		if (n == -1) {
			return;
		}
		f(n - 1);
		System.out.println(n);
	}*/

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
