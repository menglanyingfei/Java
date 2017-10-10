package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-6-23
 */
public class Main03_signalReport {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String[] R = {"unreadable", 
				"barely readable, occasional words distinguishable",
				"readable with considerable difficulty",
				"readable with practically no difficulty",
				"perfectly readable"};
		
		String[] S = {"Faint signals, barely perceptible",
				"Very weak signals",
				"Weak signals",
				"Fair signals",
				"Fairly good signals",
				"Good signals",
				"Moderately strong signals",
				"Strong signals",
				"Extremely strong signals"
		};
		
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int r = input / 10;
		int s = input % 10;
		System.out.println(S[s - 1] + ", " + R[r - 1] + ".");
	}
}













