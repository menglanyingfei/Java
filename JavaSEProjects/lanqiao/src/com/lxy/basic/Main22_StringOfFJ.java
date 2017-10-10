package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-7
 */
public class Main22_StringOfFJ {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		String str = f(n);
		System.out.println(str);
	}

	private static String f(int n) {
		if (n == 1) {
			return "A";
		}
		char c = (char) (65 + n - 1);
		return f(n -1) + c + f(n - 1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
