package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-6-22
 */
public class Main01_dataConvert {

	/**
	 * @param args
	 *     °F = (9/5)*°C + 32
	 */
	public static void main(String[] args) {
		int F;
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		double C;
	    C	= (F - 32) * (5 / 9.0);
		System.out.println((int) C);
	}

}













