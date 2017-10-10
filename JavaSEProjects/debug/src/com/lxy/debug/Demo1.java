package com.lxy.debug;

import java.util.Arrays;

public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[]{11, 22, 33, 44, 55};
		int index = Arrays.binarySearch(arr, 55);
//		System.out.println(arr);
		System.out.println(index);
	}	
	
}
