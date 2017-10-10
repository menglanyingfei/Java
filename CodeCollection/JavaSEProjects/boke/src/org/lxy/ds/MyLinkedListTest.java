package org.lxy.ds;
/**
 * @author menglanyingfei
 * @date 2017-5-14
 */
public class MyLinkedListTest {
	public static void main(String[] args) {
		MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		
		System.out.println(myLinkedList.size()); // 5
		
		System.out.println(myLinkedList.get(0)); // 1
		System.out.println(myLinkedList.get(1)); // 2
		
		System.out.println(myLinkedList.set(0, 15)); // 1, set方法返回之前被修改的旧值
		System.out.println(myLinkedList.get(0)); // 15
		
		System.out.println(myLinkedList.remove(0)); // 15
		System.out.println(myLinkedList.get(0)); // 2
		
	}
}
