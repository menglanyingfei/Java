package org.lxy.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author menglanyingfei
 * @date 2017-5-7
 */
public class MyThreadLocal<T> {
	private Map<Thread, T> map;
	
	private MyThreadLocal() {
		map = new HashMap<Thread, T>();
	}
	public void set(T t) {
		map.put(Thread.currentThread(), t);
	}
	public T get() {
		return map.get(Thread.currentThread());
	}
}







