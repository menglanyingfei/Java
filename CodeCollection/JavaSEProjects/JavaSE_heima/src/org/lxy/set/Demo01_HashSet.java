package org.lxy.set;

import java.util.HashSet;

import org.lxy.bean.Student;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Demo01_HashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("a");
		hs.add("a");
		hs.add("b");
		hs.add("c");
		System.out.println(hs); // [b, c, a]
		
		HashSet<Student> hs1 = new HashSet<Student>();
		hs1.add(new Student(20, "li"));
		hs1.add(new Student(20, "li"));
		hs1.add(new Student(20, "wang"));
		System.out.println(hs1); // [Student [age=20, name=li], Student [age=20, name=wang]]
	}

}















