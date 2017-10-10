package com.lxy.enumtest;

import org.junit.Test;

/**
 * 枚举的API
 * @author 15072
 *
 */
public class Demo1 {

	/**
	 * 1.已知枚举对象，获取枚举的名称和下标
	 */
	@Test
	public void run1() {
		//获取枚举对象
		Love girl = Love.GIRL;
		//获取名称
		System.out.println(girl.name());
		//获取下标值
		System.out.println(girl.ordinal());
	}
	
	/**
	 * 2.已知枚举名称，获取枚举对象和下标
	 */
	@Test
	public void run2() {
		String name = "READ";
		//获取枚举对象
		Love read = Enum.valueOf(Love.class , name);
		// 获取下标值
		System.out.println(read.ordinal());
		Love read1 = Love.valueOf(name);
		System.out.println(read1.ordinal());
	}
	
	/**
	 * 3.已知枚举下标，获取枚举对象和名称
	 */
	@Test
	public void run3() {
		int idx = 2;
		Love[] loves = Love.values();
		Love coding = loves[idx];
		System.out.println(coding.name());
	}
	
}

enum Love {
	GIRL, READ, CODING;
}



































