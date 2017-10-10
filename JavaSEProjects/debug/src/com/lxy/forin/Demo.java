package com.lxy.forin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * 增强for循环
 * @author 15072
 *
 */
public class Demo {
	
	@Test
	public void run() {
		List<String> list = new ArrayList<String>();
		list.add("aa");
		list.add("bb");
		list.add("cc");
		
		System.out.println("======================");
		
		// 使用增强for循环遍历
		for (String str : list) {
			System.out.println(str);
		}
		
		System.out.println("======================");
		
		Iterator<String> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}			
	}	
}
