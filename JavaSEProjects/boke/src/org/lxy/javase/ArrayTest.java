package org.lxy.javase;
/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class ArrayTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] strs = {"C", "C++", "Java", "JavaScript", "PHP"};
		// 数组之普通for循环遍历
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + " ");	// C C++ Java JavaScript PHP 
		}		
		System.out.println("\n============================");
		// 数组之增强for循环遍历
		for (String string : strs) {
			System.out.print(string + " ");	// C C++ Java JavaScript PHP 
		}
	}
}
