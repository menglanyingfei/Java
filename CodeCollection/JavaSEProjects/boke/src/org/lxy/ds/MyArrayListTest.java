package org.lxy.ds;

import org.lxy.ds.MyArrayList;

/**
 * @author menglanyingfei
 * @date 2017-5-6
 */
public class MyArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建线性表对象
		MyArrayList<Integer> myArrayList = new MyArrayList<>();
		// 第一种添加元素方式, add(E x)
		myArrayList.add(1); // 1
		myArrayList.add(2); // 1 2
		//myArrayList.add(5);
		
		// 第二种添加元素方式, add(int idx, E x)
		myArrayList.add(0, 5); // 5 1 2
		
		myArrayList.remove(1); // 5 2
		
		myArrayList.set(0, 6); // 6 2
		
		System.out.println(myArrayList.get(0));
		
		myArrayList.show();
	}
}