package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-23
 */
public class Main18_MatrixArea {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] x = new double[4];
		double[] y = new double[4];
		double[] z = new double[4];
		for (int i = 0; i < 4; i++) {
			x[i] = sc.nextDouble();
			y[i] = sc.nextDouble();
		}
		z[0] = Math.max(Math.min(x[0], x[1]), Math.min(x[2], x[3])); // x1
		z[1] = Math.min(Math.max(x[0], x[1]), Math.max(x[2], x[3])); // x2

		z[2] = Math.max(Math.min(y[0], y[1]), Math.min(y[2], y[3])); // y1
		z[3] = Math.min(Math.max(y[0], y[1]), Math.max(y[2], y[3])); // y2
		if (z[0] < z[1] && z[2] < z[3])
			System.out.printf("%.2f\n", (z[1] - z[0]) * (z[3] - z[2]));
		else
			System.out.println("0.00");
	}
}
