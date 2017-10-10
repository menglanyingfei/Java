package org.lxy.list;

import java.util.ArrayList;

/**
 * @author menglanyingfei
 * @date 2017-3-31
 */
public class Demo1_ArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("C");
		list.add("C");		// 可以存重复的元素, 且存储有序
		list.add("Java");
		list.add("C++");
		
		System.out.println(list);						// [C, C, Java, C++]
		// 通过get方法获得下标
		System.out.println(list.get(2));			// Java 				
	}

}














