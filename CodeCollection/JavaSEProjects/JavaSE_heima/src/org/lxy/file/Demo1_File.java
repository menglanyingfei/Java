package org.lxy.file;

import java.io.File;

/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo1_File {
	/**
	 * 构造方法摘要 
	File(File parent, String child) 
          根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。 
	File(String pathname) 
          通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。 
	File(String parent, String child) 
          根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。 
	 * @param args
	 */
	public static void main(String[] args) {
		//demo1();
		
		
	}

	public static void demo1() {
		File file = new File("F:\\repository"); // 路径
		System.out.println(file.exists());
		
		File file1 = new File("test.txt");
		System.out.println(file1.exists());
	}
}
























