package org.lxy.map;

import java.util.TreeMap;

/**
 * @author menglanyingfei
 * @date 2017-3-31
 */
public class Demo5_TreeMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("C", 3);
		tm.put("Java", 1);
		tm.put("PHP", 6);
		// 用法很类似HashMap
		System.out.println(tm); // {C=3, Java=1, PHP=6}
	}

}
