package org.lxy.case01_guess_num;

import java.util.*;

/**
 * @author menglanyingfei
 * @date 2017-2-11
 */
public class GuessNum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数, 范围在1~100之间:");
		int guessNum = (int) (Math.random() * 100) + 1;			// 生成1~100的伪随机整数
		while (true) {																// 无限循环
			int result = sc.nextInt();
			if (result > guessNum) {
				System.out.println("大了");
			} else if (result < guessNum) {
				System.out.println("小了");
			} else {
				System.out.println("恭喜您! 猜中了.");
				break;																	// 猜中就跳出循环, 游戏结束了
			}
		}
		
		sc.close();
	}
}
