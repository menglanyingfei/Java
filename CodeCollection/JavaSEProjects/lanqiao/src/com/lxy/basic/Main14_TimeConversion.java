package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-20
 */
public class Main14_TimeConversion {
	/**
	 * @param args
	 * 次数:1
	 * 样例输入
		5436
		样例输出
		1:30:36
		3661 61 
		1:1:1
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		int hour = num / 3600;
		int min = num % 3600 / 60;
		int second = num % 3600 % 60;
		System.out.println(hour + ":" + min + ":" + second);
	}
	
	
	
	
	

}
