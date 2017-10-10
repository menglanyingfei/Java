package org.lxy.object;
/**
 * @author menglanyingfei
 * @date 2017-2-17
 */
public class Demo1_GetClass {

	/**
	 * 全类名的获取
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		Class<? extends Person> clazz = p.getClass();
		String name = clazz.getName();
		System.out.println(name);
	}

}
