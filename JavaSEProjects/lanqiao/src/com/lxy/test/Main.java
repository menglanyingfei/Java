package com.lxy.test;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	// 4
	// 50.2654825
	// 80
	// 20106.1929830
	// 5120
	// 82354966.4582643
	public static void main(String[] args) {
		double PI = 3.14159265358979323;
		Scanner input = new Scanner(System.in);
		int r = input.nextInt();
		double S = PI * r * r;
//		String double_str = String.format("%.7f", S);
//		System.out.println(double_str);
		
		// 另外的正解:
		System.out.printf("%.7f", S);
		
		
		
		//System.out.println(S);
		//System.out.println(Math.round(S * 10000000));
		//System.out.println((double)Math.round(S * 10000000));
		
		// 错误1
//		System.out.println((double)Math.round(S * 10000000) / 10000000);
		

//		double result = Double.valueOf(double_str);
//		System.out.println(result);
	}

}
