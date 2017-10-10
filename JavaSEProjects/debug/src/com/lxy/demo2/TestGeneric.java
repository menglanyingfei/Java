package com.lxy.demo2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class TestGeneric {

	@Test
	public void run1() {
		// List集合
		List<String> list = new ArrayList<String>();
		list.add("Java");
		list.add("C");
		list.add("C++");
	
		// 循环遍历  三种 普通for 增强for 迭代器
		for (int i = 0; i <list.size(); i++) {
			String str = list.get(i);
			System.out.println(str);
		}
		System.out.println("============");
		// 增强for循环  for(类型 变量 : 集合) {}
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println("============");
		//迭代器
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	@Test
	public void run2() {
		Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("2");
		set.add("3");
		set.add("4");
		//遍历方式		迭代器和增强for循环
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("============");
		for (String str : set) {
			System.out.println(str);
		}
	}
	
	@Test
	public void run3() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("aa", 1);
		map.put("bb", 2);
		map.put("cc", 3);
		
		// 遍历两种		获取key
		Set<String> keys = map.keySet();
		for (String key : keys) {
			Integer value = map.get(key);
			System.out.println(key + " " + value);
		}
		System.out.println("============");
		Set<Entry<String, Integer>> entrys = map.entrySet();
		for (Entry<String, Integer> entry : entrys) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
