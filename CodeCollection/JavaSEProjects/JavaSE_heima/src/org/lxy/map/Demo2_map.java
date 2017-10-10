package org.lxy.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Set;

/**
 * @author menglanyingfei
 * @date 2017-3-20
 */
public class Demo2_map {
	/**
	 * Map集合的遍历之键值对对象找键和值
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<>();
		m.put("li", 20);
		m.put("lili", 21);
		m.put("lixing", 23);
		
		// Map.Entry说明Entry是Map的内部接口, 将键和值封装成了Entry对象, 并存储在Set集合中
		Set<Entry<String, Integer>> entrySet = m.entrySet();
		Iterator<Entry<String, Integer>> it = entrySet.iterator();
		while (it.hasNext()) {
			Entry<String, Integer> en = it.next();
			String key = en.getKey();
			Integer value = en.getValue();
			System.out.println(key + " = " + value);
		}
		
		for (Entry<String, Integer> en : m.entrySet()) {
			System.out.println(en.getKey() + " = " + en.getValue());
		}
	}
}






















