package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-6-23
 */
public class Main05_binaryOfNum {

	/**
	 * @param args
	 * 342315
	 * 001101
	 * 13
	 */
	// 返回0和1
	public static int checkNum(int num) {
		while (num >= 2) {
			num -= 2;
		}
		return num;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// input为输入的数
		int input = sc.nextInt();
		int count = 1;
		int n = 1;
		int num;
		int result = 0;
		
		while (input != 0) {
			num = input % 10;
			if (checkNum(num) == checkNum(count)) {
				result += n;
			}
			n *= 2;
			count++;
			input /= 10;
		}
		
		System.out.println(result);
	}
}

















