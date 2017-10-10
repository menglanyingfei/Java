package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-6-23
 */
public class Main04_numOfOddAndEven {

	/**
	 * @param args
	 * 奇偶个数
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int odd = 0, even = 0;
		int num = sc.nextInt();
		while (num != -1) {
			if (num % 2 == 1) {
				odd++;
			} else {
				even++;
			}
			num = sc.nextInt();
		}
		sc.close();
		System.out.println(odd + " " + even);
	}

}




























