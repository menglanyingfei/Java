package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-23
 */
public class Main17_MatrixMultiplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		long[][] a = new long[n][n];
		long[][] b = new long[n][n];
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				b[i][j] = a[i][j] = sc.nextLong();
		if (m == 0)
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++) {
					if (i == j)
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				}
				System.out.println();
			}
		else if (m == 1)
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++)
					System.out.print(a[i][j] + " ");
				System.out.println();
			}
		else {
			for (int z = 1; z < m; z++) {
				long[][] tmp = new long[n][n];
				for (i = 0; i < n; i++) {
					for (j = 0; j < n; j++) {
						long add = 0;
						for (int y = 0; y < n; y++) {
							add += a[i][y] * b[y][j];
						}
						tmp[i][j] = add;
					}
				}
				b = tmp;
			}
			for (i = 0; i < n; i++) {
				for (j = 0; j < n; j++)
					System.out.print(b[i][j] + " ");
				System.out.println();
			}
		}

	}
}
