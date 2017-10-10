package com.lxy.basic;

import java.util.*;

/**
 * @author menglanyingfei
 * @date 2017-2-9
 */
public class Main04_ArraySum {

	/**
	 * @param args
	 */
	/*
	 * 输入:
	 * 5
		1 3 -2 4 5
		输出:
		5
		-2
		11
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;	// 表示输入的个数
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int max = arr[0];
		int min = arr[0];
		int sum = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
			if (min > arr[i]) {
				min = arr[i];
			}
			sum += arr[i];
		}
			
		System.out.println(max);	
		System.out.println(min);	
		System.out.println(sum);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
