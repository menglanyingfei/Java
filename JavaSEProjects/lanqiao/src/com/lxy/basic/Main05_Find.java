package com.lxy.basic;

import java.util.*;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Main05_Find {
	/*
	 * 输入:
	 * 6
		1 9 4 8 3 9
		9 
		输出:
		2
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		int[] arr = new int[sum];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int find = sc.nextInt();
		for (int i = 0; i < arr.length; i++) { 
			if (find == arr[i]) {
				System.out.println(i + 1);
				return;
			}
		}
		
		System.out.println(-1);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
