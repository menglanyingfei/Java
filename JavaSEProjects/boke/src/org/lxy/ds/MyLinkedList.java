package org.lxy.ds;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * 
 * @author lxy
 *
 * @param <E>
 */
public class MyLinkedList<E> implements Iterable<E> {
	private int theSize; // 容器内元素的个数
	private int modCount = 0; // Modified Count代表自从构造以来对链表所做改变的次数
	private Node<E> beginMarker;
	private Node<E> endMarker;

	// 静态内部类Node实现节点之间的连接
	private static class Node<E> {
		public E data;
		public Node<E> prev;
		public Node<E> next;

		public Node(E d, Node<E> p, Node<E> n) {
			data = d;
			prev = p;
			next = n;
		}
	}
	
	// 无参的构造方法, 构造一个MyLinkedList类的对象之前, 清空里面的元素
	public MyLinkedList() {
		clear();
	}

	public void clear() {
		beginMarker = new Node<E>(null, null, null);
		endMarker = new Node<E>(null, beginMarker, null);
		beginMarker.next = endMarker;

		theSize = 0;
		modCount++;
	}
	
	// 下面的方法, 即对容器(MyLinkedList对象)的操作, 方法名大多见名知义
	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean add(E x) {
		add(size(), x);
		return true;
	}

	public void add(int idx, E x) {
		addBefore(getNode(idx), x);
	}

	public E get(int idx) {
		return getNode(idx).data;
	}

	public E set(int idx, E newVal) {
		Node<E> p = getNode(idx);
		E oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}

	public E remove(int idx) {
		return remove(getNode(idx));
	}

	private void addBefore(Node<E> p, E x) {
		Node<E> newNode = new Node<E>(x, p.prev, p);
		newNode.prev.next = newNode;
		p.prev = newNode;
		theSize++;
		modCount++;
	}

	private E remove(Node<E> p) {
		p.next.prev = p.prev;
		p.prev.next = p.next;
		theSize--;
		modCount++;
		
		return p.data;
	}

	private Node<E> getNode(int idx) {
		Node<E> p;
		
		if (idx < 0 || idx > size()) {
			throw new IndexOutOfBoundsException();
		}
		if (idx < size() / 2) {
			p = beginMarker.next;
			for (int i = 0; i < idx; i++) {
				p = p.next;
			}
		} else {
			p = endMarker;
			for (int i = size(); i > idx; i--) {
				p = p.prev;
			}
		}
		
		return p;
	}

	@Override
	public Iterator<E> iterator() {

		return new LinkedListItetator();
	}

	// MyLinkedList类中的内部Iterator类
	private class LinkedListItetator implements Iterator<E> {
		private Node<E> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		
		@Override
		public boolean hasNext() {
			return current != endMarker;
		}
		
		@Override
		public E next() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			
			E nextItem = current.data;
			current = current.next;
			okToRemove = true;
			
			return nextItem;
		}
		
		@Override
		public void remove() {
			if (modCount != expectedModCount) {
				throw new ConcurrentModificationException();
			}
			if (!okToRemove) {
				throw new IllegalStateException();
			}
			MyLinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount++;
		}
	}

}
