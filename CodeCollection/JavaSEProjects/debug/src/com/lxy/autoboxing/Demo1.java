package com.lxy.autoboxing;

//import java.util.ArrayList;
//import java.util.List;
import org.junit.Test;

/**
 * 自动装箱和拆箱
 * @author 15072
 *
 */
public class Demo1 {
	
//	@Test
//	public void run1() {
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(1);
//		
//		//自动装箱
//		Integer i = 1;
//		//自动拆箱
//		int j = i;		
//	}
	
	/*// JDK1.4版本
	public void run2() {
		List  list = new ArrayList();
		list.add(new Integer(1));
		
		//自动装箱
		Integer i = new Integer(1);
		//自动拆箱
		int j = i.intValue();	
	}*/
	
	//向下兼容
	@Test
	public void run3() {
		doX(1);
	}
	
	public void doX(double x) {
		System.out.println("double");
	}
	
	public void doX(Integer x) {
		System.out.println("Integer");
	}
	
	@Test
	public void run4() {
		Integer n1 = 100;
		Integer n2 = 100;
		Integer n3 = new Integer(100);
		Integer n4 = new Integer(100);
		Integer n5 = 128; // Integer整数范围：-128 ~ 127
		Integer n6 = 128;
		
		System.out.println(n1 == n2);
		System.out.println(n3 == n4);
		System.out.println(n5 == n6);
	}
	
}
