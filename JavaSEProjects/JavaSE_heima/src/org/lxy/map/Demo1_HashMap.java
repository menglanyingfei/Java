package org.lxy.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * @author menglanyingfei
 * @date 2017-3-20
 */
public class Demo1_HashMap {
	/**
	 * Map集合的遍历之键找值
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Integer> hm = new HashMap<>();
		hm.put("li", 20);
		hm.put("wang", 22);
		hm.put("liyang", 40);
		
		Set<String> keySet = hm.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = hm.get(key);
			System.out.println(key + " = " + value);
		}
		
		System.out.println("=========================");
		for (String key : keySet) {
			System.out.println(key + " = " + hm.get(key));
		}
	}
}


















