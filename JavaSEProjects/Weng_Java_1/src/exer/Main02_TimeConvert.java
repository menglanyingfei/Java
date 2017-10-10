package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-6-23
 */

public class Main02_TimeConvert {
	/**
	 * 一个整数，表示BJT的时和分。
	 * 整数的个位和十位表示分，百位和千位表示小时。
	 * 如果小时小于10，则没有千位部分；
	 * 如果小时是0，则没有百位部分；如果分小于10分，需要保留十位上的0。
	 * 要小心跨日的换算
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int hour = input / 100;
		int minute = input % 100;
		int newHour = hour - 8;
		if (newHour < 0) {
			newHour += 24;
		}
		int result = newHour * 100 + minute;
		System.out.println(result);
	}
}














