package com.lxy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;

/**
 * 了解反射
 * @author 15072
 *
 */
public class Demo {

	@Test
	public void run() throws Exception {
		// 三种方式获取class对象
		// 类名
//		Class clazz1 = Person.class;
//		// 通过实例
//		Class clazz2 = new Person().getClass();
//		// Class.forName
//		Class clazz3 = Class.forName("com.lxy.reflect.Person");
		System.out.println("Test");
	}

	/**
	 * 获取构造的对象
	 * @throws Exception
	 */
	@Test
	public void run1() throws Exception {
		// 获取Person的Class对象
		Class<?> clazz = Class.forName("com.lxy.reflect.Person");
		
		// clazz.getConstructors();			// 获取所有的构造方法
		// 创建实例
		// Person p = (Person) clazz.newInstance(); // 创建实例，相当于调用无参数的构造方法
		
		// 获取有参数的构造器
		Constructor<?> c = clazz.getConstructor(int.class, String.class);
		Person p2 = (Person) c.newInstance(1, "小阳");
		System.out.println(p2.getName());
	}
	
	/**
	 * 获取属性的对象
	 * @throws Exception 
	 */
	@Test
	public void run3() throws Exception {
		// 获取Person的Class对象
		Class<?> clazz = Class.forName("com.lxy.reflect.Person");
		// 声明实例
		Person p = (Person) clazz.newInstance();
		// 获取属性
		// clazz.getField("name");		// 获取是共有的name的属性
		
		Field name = clazz.getDeclaredField("name"); // 可以获取共有和私有，都能获取
	
		name.setAccessible(true);		
		name.set(p, "李小阳");
		System.out.println(name.get(p));
	}
	
	/**
	 * 获取方法
	 * @throws Exception
	 */
	@Test
	public void run4() throws Exception {
		// 获取Person的Class对象
		Class<?> clazz = Class.forName("com.lxy.reflect.Person");
		// 声明实例
		Person p = (Person) clazz.newInstance();
		
		Method m = clazz.getDeclaredMethod("setName", String.class);
//		m.setAccessible(true);
		m.invoke(p, "莉莉");		// p.setName = "莉莉";
		
		System.out.println(p.getName());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
