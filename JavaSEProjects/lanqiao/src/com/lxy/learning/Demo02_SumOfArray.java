package com.lxy.learning;
/**
 * @author menglanyingfei
 * @date 2017-2-19
 */
public class Demo02_SumOfArray {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		/*int sum = 0;
		for (int i = 0; i < 5; i++) {
			sum += arr[i];
		}
		System.out.println(sum);*/
		System.out.println(f1(arr, 0));
	}

	// 求数组arr中从begin到结束的元素和
	private static int f1(int[] arr, int begin) {
		if (begin == arr.length) {
			return 0;
		}
		int x = f1(arr, begin + 1);
		return x + arr[begin];
	}

	
	
	
	
	
	
	
}
