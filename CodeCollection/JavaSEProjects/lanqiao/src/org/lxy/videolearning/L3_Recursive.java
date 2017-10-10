package org.lxy.videolearning;
/**
 * @author menglanyingfei
 * @date 2017-4-6
 */
public class L3_Recursive {
	public static void main(String[] args) {
		/*String newStr = reversalStr("abc");
		System.out.println(newStr);*/
		
		//demo0();
		
		//demo1();
		
		//demo2();
		int[] a = {3, 2, 4, 3, 1};
		boolean[] b = new boolean[a.length]; // 表示a的对应项是否选取
		fun1(6, a, 0, 0, b);
		
	}

	public static void demo2() {
		int[] arr = new int[1000];
		fun(6, arr, 0);
	}
	
	public static void demo1() {
		System.out.println(g(3, 1));
	}
	public static void demo0() {
		int level = 6;
		
		for (int i = 0; i <= level ; i++) {
			System.out.print(printYangHuiTriangle(level, i) + " ");
		}
	}
	/**
	 * 杨辉三角m层的第n个元素
	 * @param m
	 * @param n
	 * @return

1
1 1
1 2 1
1 3 3 1

	 */
	public static int printYangHuiTriangle(int m, int n) {
		if (n == 0 || m == n) 
			return 1;
		return printYangHuiTriangle(m - 1, n) + printYangHuiTriangle(m - 1, n - 1);
	}
	
	@SuppressWarnings("unused")
	private static String reversalStr(String str) {
		if (str == null || str.length() <= 1)
			return str;
		return reversalStr(str.substring(1)) + str.charAt(0);
	}
	
	/**
	 * m个A, n个B, 组成多少排列
	 * @return
	 */
	public static int g(int m, int n) {
		if (m == 0 || n == 0)
			return 1;
		return g(m - 1, n) + g(m, n - 1);
	}
	
	/**
	 * 对i进行加法划分
	 * arr 缓冲, k: 当前的位置
	 * ?
	 * @param i
	 */
	public static void fun(int i, int[] arr, int k) {
		if (i <= 0) {
			for (int j = 0; j < k; j++)
				System.out.print(arr[j] + " ");
			System.out.println();
			return;
		}
		for (int j = i; j > 0; j--) {
			if (k > 0 && j > arr[k - 1]) continue;
			arr[k] = j;
			fun(i - j, arr, k + 1);
		}
	}
	/**
	 * @param err_sum 有错的和
	 * @param a 明细
	 * @param k 当前处理的位置
	 * @param cur_sum 前边的元素累加和
	 * @param b 记录取舍
	 * ?
	 */
	public static void fun1(int err_sum, int[] a, int k, int cur_sum, boolean[] b) {
		if (cur_sum > err_sum) return;
		if (err_sum == cur_sum) {
			for (int i = 0; i < b.length; i++)
				if (b[i] == false) System.out.print(i + " ");
			System.out.println();
			return;
		}
		if (k >= a.length) return;
		
		b[k] = false;
		fun1(err_sum, a, k + 1, cur_sum, b);
		
		b[k] = true;
		cur_sum += a[k];
		fun1(err_sum, a, k + 1, cur_sum, b);
		b[k] = false; // 回溯!!!
	}
	
}



















