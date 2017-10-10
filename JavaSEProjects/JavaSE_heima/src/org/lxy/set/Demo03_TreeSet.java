package org.lxy.set;

import java.util.Comparator;
import java.util.TreeSet;

import org.lxy.bean.Student;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Demo03_TreeSet {

	/**
	 * TreeSet集合, 唯一性, 比较性
	 * 自定义类实现comparable接口
	 * 法二: 比较器排序
	 * @param args
	 */
	public static void main(String[] args) {
		//demo1();
		// 匿名内部类
		TreeSet<String> ts = new TreeSet<String>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int num = o1.length() - o2.length();
				return num == 0 ? o1.compareTo(o2) : num;
			}
			
		});
		ts.add("a");
		ts.add("nbaa");
		ts.add("eeeeeeeee");
		ts.add("haha");
		
		System.out.println(ts);
	}

	public static void demo1() {
		TreeSet<Student> ts = new TreeSet<Student>();
		ts.add(new Student(20, "xing"));
		ts.add(new Student(21, "li"));
		ts.add(new Student(22, "xing"));
		ts.add(new Student(22, "zz"));
		ts.add(new Student(23, "aa"));
		
		System.out.println(ts);
	}

}

/*class CompareByLen implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int num = o1.length() - o2.length();
		return num == 0 ? o1.compareTo(o2) : num;
	}
	
}*/














