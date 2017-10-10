package org.lxy.file;

import java.io.File;
import java.io.IOException;

/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo2_Create {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		File dir1 = new File("abc\\aa");
		System.out.println(dir1.mkdirs());
	}

	public static void demo1() throws IOException {
		File file1 = new File("create");
		file1.createNewFile();
	}

}




















