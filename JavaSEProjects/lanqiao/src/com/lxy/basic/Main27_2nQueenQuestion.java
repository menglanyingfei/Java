package com.lxy.basic;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-13
 */
public class Main27_2nQueenQuestion {
	/**
	 * @param args
	 */

	static int n, m, map[][], Count;
	static boolean v[][], a[][], b[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(new InputStreamReader(System.in));
		while (sc.hasNext()) {
			n = sc.nextInt();
			map = new int[n][n];
			v = new boolean[n][n];
			a = new boolean[3][2 * n];
			b = new boolean[3][2 * n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			Count = 0;
			dfs(0);
			System.out.println(Count);
		}
	}

	private static void dfs(int i) {
		if (i == n) {
			Count++;
			return;
		}
		for (int j = 0; j < n; j++) {
			if (!v[i][j] && map[i][j] != 0) {
				if (!a[0][i + j] && !a[1][n + i - j] && !a[2][j]) {
					v[i][j] = true;
					a[0][i + j] = a[1][n + i - j] = a[2][j] = true;
					for (int k = 0; k < n; k++) {
						if (!v[i][k] && map[i][k] != 0) {

							if (!b[0][i + k] && !b[1][n + i - k] && !b[2][k]) {

								v[i][k] = true;
								b[0][i + k] = b[1][n + i - k] = b[2][k] = true;
								dfs(i + 1);
								v[i][k] = false;
								b[0][i + k] = b[1][n + i - k] = b[2][k] = false;

							}
						}
					}
					v[i][j] = false;// 注意放置的位置
					a[0][i + j] = a[1][n + i - j] = a[2][j] = false;
				}
			}
		}
	}
}
