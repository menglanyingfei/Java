package org.lxy.javase_2;
/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class ComparisonOfReferenceDataTypes {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student1 s1 = new Student1("Java", 19);
		Student1 s2 = new Student1("Java", 19);
		
		System.out.println("未重写equals方法前:");
		System.out.println(s1 == s2);			// false
		System.out.println(s1.equals(s2));		// false
		
		Student2 s3 = new Student2("Java", 19);
		Student2 s4 = new Student2("Java", 19);
		
		System.out.println("重写equals方法后:");
		System.out.println(s3 == s4);			// false
		System.out.println(s3.equals(s4));		// true
	}
}
