package com.lxy.basic;

import java.util.*;

public class Main01 {

	/**
	 * @param args
	 */
	/*
	 * 2013
	 * no
	 * 
	 * 2016
	 * yes
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int y = input.nextInt();
		if (((y % 4 == 0) && (y % 100 != 0)) || y % 400 == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

}
