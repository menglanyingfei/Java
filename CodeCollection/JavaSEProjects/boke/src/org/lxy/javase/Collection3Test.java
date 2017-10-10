package org.lxy.javase;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class Collection3Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Collection<Student> coll = new ArrayList<>();
         coll.add(new Student("PHP", 10));     
         coll.add(new Student("Java", 15));
         coll.add(new Student("JS", 9));
         
         Object[] arrs = coll.toArray();               // 将集合转换成数组(普通for循环)
         for (int i = 0; i <  arrs.length; i++) {
             Student s = (Student) arrs[i];            // 强转成Student
             System.out.println(s);
         }
         
         System.out.println("=====================");
         for (Object object : arrs) {
        	 Student s = (Student) object;            // 强转成Student 
             System.out.println(s);
		}
	}

}
