package com.lxy.learning;
/**
 * @author menglanyingfei
 * @date 2017-2-18
 */
public class Demo03_IsSameString {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "abc";
//		System.out.println(s1.equals(s2));
		System.out.println(f(s1, s2));
	}

	private static boolean f(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}	
		if (s1.isEmpty())
			return true;
		if (s1.charAt(0) != s2.charAt(0)) {
			return false;
		}	
		return f(s1.substring(1), s2.substring(1));	
	}
	
	
	
	
	
	
	
	

}
