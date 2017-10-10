package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-18
 * 此题存在BUG, 需改进!
 */
public class Main13_Find {
	public static boolean judge(int n) {
		int i, sum = 0;
		for (i = 1; i < n / 2 + 1; i++)
			if (n % i == 0)
				sum += i;
		if (sum == n)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();
		int m = in.nextInt();
		int i, sum = 0;
		boolean frist = true;
		for (i = n; i <= m; i++) {
			if (judge(i)) {
				if (frist) {
					System.out.print(i);
					frist = false;
					sum++;
				} else {
					System.out.print(" " + i);
					sum++;
				}
			}
		}
		if (sum == 0)
			System.out.println("NIL");
	}
}
