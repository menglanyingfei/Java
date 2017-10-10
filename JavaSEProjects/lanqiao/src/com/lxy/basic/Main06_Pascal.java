package com.lxy.basic;

import java.util.*;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Main06_Pascal {
	/**
	 * 					  １
　　　　　　　１　１
　　　　　　１　２　１
　　　　　１　３　３　１
　　　　１　４　６　４　１
　　　１　５　10　10　５　１
　　１　６　15　20　15　６　１
　１　７　21　35　35　21　７　１
１　８　28　56　70　56　28　８　１
	关键: arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
	 * @param args
	 * 输入行数:
	 * 4
	 * 输出:
	 * 1
		1 1
		1 2 1
		1 3 3 1
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			arr[i][0] = 1;
			arr[i][i] = 1;
		}
		for (int i = 2; i < n; i++) {
			for (int j = 1; j < i; j++) {
				arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
