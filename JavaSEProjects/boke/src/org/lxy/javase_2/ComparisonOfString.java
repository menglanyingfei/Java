package org.lxy.javase_2;
/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class ComparisonOfString {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		
		System.out.println(str1 == str2);		 		// true
		System.out.println(str1.equals(str2)); 		// true 
	}
}
