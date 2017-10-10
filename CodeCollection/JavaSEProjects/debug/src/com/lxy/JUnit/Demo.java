package com.lxy.JUnit;

import junit.framework.Assert;

import org.junit.Test;

public class Demo {

	public int add(int x, int y) {
		return x + y;
	}
	
	@Test
	public void test() {
		int num = add(4, 5);
		Assert.assertEquals(9, num);
	}
	
}
