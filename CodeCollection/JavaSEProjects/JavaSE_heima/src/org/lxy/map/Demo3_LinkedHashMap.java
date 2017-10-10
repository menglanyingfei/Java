package org.lxy.map;

import java.util.LinkedHashMap;

/**
 * @author menglanyingfei
 * @date 2017-3-21
 */
public class Demo3_LinkedHashMap {
	/**
	 * 怎么存就怎么取
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
		lhm.put("li", 20);
		lhm.put("lili", 20);
		lhm.put("liyang", 21);
		
		System.out.println(lhm); // 注意, 存的顺序和运行显示的顺序一致!
	}
}





























