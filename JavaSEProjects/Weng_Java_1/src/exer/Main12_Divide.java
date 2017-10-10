package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-18
 */
public class Main12_Divide {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		boolean flag = true;
		int temp = n;
		for (int i = 2; i <= temp; ++i) {
			while (i != n) {
				if (temp % i == 0) {
					if (flag) {
						System.out.printf("%d=%d", n, i);
						flag = false;
					} else
						System.out.printf("x%d", i);
					temp /= i;
				} else
					break;
			}
		}

		if (flag)
			System.out.printf("%d=%d", n, n);
	}

}
