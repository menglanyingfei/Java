package org.lxy.test;

import java.io.File;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Test1 {
	public static File getDir() {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个文件夹路径:");
		
		while (true) {
			String line = sc.nextLine();
			File dir = new File(line);
			if (!dir.exists()) {
				System.out.println("您录入的文件夹路径不存在, 请输入一个文件夹路径:");
			} else if (dir.isFile()) {
				System.out.println("您录入的是文件路径, 请输入一个文件夹路径:");
			} else {
				return dir;
			}
		}
	}
}














