package org.lxy.object;

/**
 * @author menglanyingfei
 * @date 2017-2-17
 */
public class Demo3_Equals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p1 = new Person("小阳", 20);
		Person p2 = new Person("小阳", 20);
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}
}
