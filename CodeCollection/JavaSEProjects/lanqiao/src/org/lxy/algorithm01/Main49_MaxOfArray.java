package org.lxy.algorithm01;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Main49_MaxOfArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // n为数组的长度
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int max = arr[0], index = 0;
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				index = i;
			}
		}
		System.out.println(max + " " + index);
	}

}





















