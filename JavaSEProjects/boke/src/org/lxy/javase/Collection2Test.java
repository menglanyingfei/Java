package org.lxy.javase;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class Collection2Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Collection<String> c = new ArrayList<>();
         c.add("aa");
         c.add("bb");
         c.add("cc");
         c.add("dd");
         Iterator<String> it = c.iterator();      // 获取迭代器的引用
         while(it.hasNext()) {                   		// 集合中的迭代方法(遍历)
             System.out.print(it.next() + " ");	// aa bb cc dd 
         }     
	}
}
