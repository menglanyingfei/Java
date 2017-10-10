package org.lxy.reflection;

import org.lxy.bean.Person;

/**
 * @author menglanyingfei
 * @date 2017-4-19
 */
public class Demo1_Reflect {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> clazz1 = Class.forName("org.lxy.bean.Person");
		Class<Person> clazz2 = Person.class;
		
		Person p = new Person();
		Class<? extends Person> clazz3 = p.getClass();
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz2 == clazz3);
	}

}























