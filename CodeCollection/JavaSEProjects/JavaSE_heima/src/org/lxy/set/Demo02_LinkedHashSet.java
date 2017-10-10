package org.lxy.set;

import java.util.LinkedHashSet;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Demo02_LinkedHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("b");
		lhs.add("a");
		lhs.add("a");
		lhs.add("c");
		System.out.println(lhs);
	}

}


















