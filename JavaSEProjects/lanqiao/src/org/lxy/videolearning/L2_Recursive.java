package org.lxy.videolearning;
/**
 * @author menglanyingfei
 * @date 2017-4-5
 */
public class L2_Recursive {
	/**
	 * 1. 在i个球里取出j个(不放回)
	 * 2. 求n个元素的全排列
	 * @param args
	 */
	public static int f(int i, int j) {
		if (i < j) {
			return 0;
		}
		if (i == j)
			return 1;
		if (j == 0)
			return 1;
		return f(i - 1, j - 1) + f(i - 1, j);
	}
	public static void main(String[] args) {
		/*int ans = f(5, 3);
		System.out.println(ans); // 10
		*/
		
		/*char[] data = "ABCDE".toCharArray();
		f1(data, 0);*/
		int k = f2("fabckd", "xbacd");
		System.out.println(k); // 3
	}
	
	private static int f2(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		if (s1.charAt(0) == s2.charAt(0))
			return f2(s1.substring(1), s2.substring(1)) + 1;
		else
			return Math.max(f2(s1.substring(1), s2), f2(s1, s2.substring(1)));
	}
	
	// k: 当前的交换位置(关注点), 与其后的元素交换
	@SuppressWarnings("unused")
	private static void f1(char[] data, int k) {
		if (k == data.length - 1) {
			for (int i = 0; i < data.length; i++) {
				System.out.print(data[i] + " ");
			}
			System.out.println();
		}
		for (int i = k; i < data.length; i++) {
			{
				// 试探
				char t = data[k];
				data[k] = data[i];
				data[i] = t;
			}
			f1(data, k + 1);
			{
				// 回溯
				char t = data[k];
				data[k] = data[i];
				data[i] = t;
			}
		}
	}

}




















