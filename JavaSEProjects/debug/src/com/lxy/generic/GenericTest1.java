package com.lxy.generic;

import java.util.Arrays;

import org.junit.Test;

public class GenericTest1 {

	/**
	 * 测试
	 * 补充：
	 * Ctrl + D : 删除当前行 
	 */
	@Test
	public void run1() {
		Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
		change(arr, 1, 3);
		System.out.println(Arrays.toString(arr));
		String[] strarr = new String[]{"a", "b", "c", "d", "e", "f"};
		change(strarr, 1, 3);
		System.out.println(Arrays.toString(strarr));
	}
//	public void change(String[] strarr, int idx1, int idx2) {
//		String temp = strarr[idx1];
//		strarr[idx1] = strarr[idx2];
//		strarr[idx2] = temp;			
//	}
//	/**
//	 * @param arr
//	 * @param idx1
//	 * @param idx2
//	 */
//	public void change(int[] arr, int idx1, int idx2) {
//			int temp = arr[idx1];
//			arr[idx1] = arr[idx2];
//			arr[idx2] = temp;				
//	}
	/**
	 * 自定义泛型方法
	 * 声明泛型<T>放在返回值之前
	 * @param strarr
	 * @param idx1
	 * @param idx2
	 */
	public <T> void change(T[] strarr, int idx1, int idx2) {
		T temp = strarr[idx1];
		strarr[idx1] = strarr[idx2];
		strarr[idx2] = temp;
	}
	/**
	 * 颠倒所有的元素
	 */
	@Test
	public void run2() {
		String[] strarr = new String[]{"a", "b", "c", "d", "e", "f"};	
		reset(strarr);
		System.out.println(Arrays.toString(strarr));
	}
	public <T> void reset(T[] arr) {
		for (int i = 0; i < arr.length / 2; i++) {
			T temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
