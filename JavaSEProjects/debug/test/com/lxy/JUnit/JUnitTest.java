package com.lxy.JUnit;

import org.junit.Test;

/**
 * 测试
 * @author 15072
 */
public class JUnitTest {
	/**
	 * public void 不能有参数列表
	 */
	@Test
	public void testEat() {
		JUnit t = new JUnit();
//		int a = 10 / 0;
		t.eat();	
	}
	
	@Test
	public void run() {
		JUnit t = new JUnit();
		t.sleep();
	}
	@Test
	public void testSmile() {
		JUnit t = new JUnit();
		t.smile();
	}
	
}
