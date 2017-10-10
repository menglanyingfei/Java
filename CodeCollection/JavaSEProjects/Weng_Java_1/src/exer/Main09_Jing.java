package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-12
 */
public class Main09_Jing {

	/**
	 * @param args
	 * 待解决?
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] tictactoe = new int[n][n];

		for (int i = 0; i < n; ++i)
			for (int j = 0; j < n; ++j)
				tictactoe[i][j] = in.nextInt();

		int num, tag = -1;

		for (int i = 0; i < n; ++i) {   // 搜索行
			num = tictactoe[i][0];
			for (int j = 0; j < n - 1; ++j) {
				if (tictactoe[i][j] != tictactoe[i][j + 1])
					break;
				if (j == n - 2)
					tag = num;
			}
		}

		for (int j = 0; j < n; ++j) { // 搜索列
			num = tictactoe[0][j];
			for (int i = 0; i < n - 1; ++i) {
				if (tictactoe[i][j] != tictactoe[i + 1][j])
					break;
				if (i == n - 2)
					tag = num;
			}

		}

		for (int i = 0; i < n - 1; ++i) { // 正对角线
			if (tictactoe[i][i] != tictactoe[i + 1][i + 1])
				break;
			if (i == n - 2)
				tag = tictactoe[0][0];
		}

		for (int i = 0; i < n - 1; ++i) { // 反对角线
			if (tictactoe[n - 1 - i][i] != tictactoe[n - 2 - i][i + 1])
				break;
			if (i == n - 2)
				tag = tictactoe[n - 1][0];
		}

		if (tag == 1)
			System.out.println("X");
		else if (tag == 0)
			System.out.println("O");
		else
			System.out.println("NIL");
	}

}
