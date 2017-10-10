package org.lxy.file;

import java.io.File;

/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo3_TestOfFile {

	/**
	 * 
	 * @param args
	 */
	// public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组
	public static void main(String[] args) {
		File file = new File("F:\\");
		File[] files = file.listFiles();
		
		for (File file1 : files) { 
				System.out.println(file1);
		}
	}

}
