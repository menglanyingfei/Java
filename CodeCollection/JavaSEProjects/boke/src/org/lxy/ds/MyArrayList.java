package org.lxy.ds;
/**
 * 自定义的ArrayList
 * @author menglanyingfei
 * @date 2017-5-6
 */
public class MyArrayList<E> {
	// 静态变量DEFAULT_CAPACITY, 代表初始数组默认大小
	private static final int DEFAULT_CAPACITY = 6;
	
	// 线性表当前大小
	private int theSize;
	// 实现该线性表的数组
	private E [] theItems;	
	
	// 无参构造
	public MyArrayList () {
		clear();
	}
	// 初始化
	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}
	// 确保theSize<=DEFAULT_CAPACITY
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		// 中间变量, 用来存之前数组里的值
		E [] old = theItems;
		// 强制类型转换
		theItems = (E[]) new Object[newCapacity]; 
		for (int i = 0; i < size(); i++) {
			theItems[i] = old[i];
		}
	}
	// 返回线性表当前大小
	public int size() {	
		return theSize;
	}
	// 增
	public boolean add(E x) {
		add(size(), x);
		return true;
	}
	public void add(int idx, E x) {
		if (theItems.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		for (int i = theSize; i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[idx] = x;
		
		theSize++;
	}
	// 删
	public E remove(int idx) {
		E removedItem = theItems[idx];
		for (int i = idx; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		theSize--;
		return removedItem;	
	}
	// 改
	public E set(int idx, E newVal) {
		if (idx < 0 || idx >= size()) {
			// 抛出数组索引越界异常
			throw new ArrayIndexOutOfBoundsException();
		}
		E old = theItems[idx];
		theItems[idx] = newVal;
		return old;
	}
	// 查
	public E get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}
	// 显示线性表中的数据
	public void show() {
		for (int i = 0; i < size(); i++) {
			System.out.print(theItems[i] + " ");
		}
	}
}























