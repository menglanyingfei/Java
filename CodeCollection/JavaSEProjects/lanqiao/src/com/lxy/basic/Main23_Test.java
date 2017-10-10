package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-6
 */
public class Main23_Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 接收数据
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                        a[i][j] = sc.nextInt();
                }
        }
        sc.close();
        // 统计结果
        int count;
        for (int j = 0; j < n; j++) {
                count = 0;
                for (int i = 0; i < n; i++) {
                        count += a[i][j];
                }
                if (count > n / 2)
                        System.out.print((j + 1) + " ");
        }
	}
}
