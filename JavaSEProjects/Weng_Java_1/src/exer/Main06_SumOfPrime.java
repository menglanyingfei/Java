package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-12
 */
public class Main06_SumOfPrime {

	/**
	 * @param args
	 *            输入格式: 两个整数，第一个表示n，第二个表示m。 输出格式：
	 *            一个整数，表示第n个素数到第m个素数之间所有的素数的和，包括第n个素数和第m个素数。
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		int count = 0; // 计数
		int sum = 0;

		if (0 < n && n <= m && m <= 200) {
			for (int i = 2; i <= 2000; i++) {
				boolean flag = true;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						flag = false;
						break;
					}
				}
				if (flag) {
					count++;
					if (count >= n)
						sum = sum + i;
					if (count == m)
						break;
				}
			}
			System.out.println(sum);
		}

	}

}
