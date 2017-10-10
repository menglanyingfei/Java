package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-12
 */
public class Main08_PolynomialAddition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] num = new int[2][120];
		int i, size, New, max = 0, tag = 0;

		for (i = 0; i < 2; i++) { // 输入两个多项式
			size = in.nextInt();// 第一项为最高项
			if (max < size)
				max = size;

			num[i][size] = in.nextInt();
			if (size == 0) // 第一项为0，直接输入下一个多项式
				continue;
			do {
				// 输入直到最终为0项
				New = in.nextInt();
				num[i][New] += in.nextInt();
			} while (New != 0);
		}
		/***** 输出 *****/
		for (i = max; i >= 0; i--) {
			if (max == 0)// 只有常数项，输出，结束
			{
				System.out.print((num[0][i] + num[1][i]));
				break;
			}
			if ((num[0][i] + num[1][i]) != 0) { // 系数不为0
				if (tag == 1) 
					if ((num[0][i] + num[1][i]) >= 0)// 非第一项 输出加号
						System.out.print("+");
				if ((num[0][i] + num[1][i]) != 1 || i == 0)
					System.out.print(num[0][i] + num[1][i]);
				if (i != 0)// 不为常数项，输出x
					System.out.print("x");
				if (i != 0 && i != 1)// 不为常数项和x的一次方，输出次数
					System.out.print(i);
				tag = 1;// 有过一次输出，即 可以输出符号
			}
			if (tag == 0 && i == 0 && (num[0][i] + num[1][i]) == 0)
				System.out.print((num[0][i] + num[1][i]));

		}
	}

}
