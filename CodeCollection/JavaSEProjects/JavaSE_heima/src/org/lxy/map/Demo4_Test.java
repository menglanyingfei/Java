package org.lxy.map;

import java.util.HashMap;

/**
 * @author menglanyingfei
 * @date 2017-3-21
 */
public class Demo4_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "aabbbcccc";
		char[] arr = str.toCharArray();
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char c : arr) {
			/*if (!hm.containsKey(c)) {
				hm.put(c, 1);
			} else {
				hm.put(c, hm.get(c) + 1);
			}*/
			
			hm.put(c, !hm.containsKey(c) ? 1 : hm.get(c) + 1);
		}
		for (Character key : hm.keySet()) {
			System.out.println(key + " = " + hm.get(key));
		}
	}

}




























