package org.lxy.io1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author menglanyingfei
 * @date 2017-3-23
 */
public class Demo1_FileInputStream {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
//		demo1();
		FileInputStream fis = new FileInputStream("test.txt");		
		int b;
		while ((b = fis.read()) != -1) {
			System.out.println(b);
		}
		fis.close();
	}

	public static void demo1() throws FileNotFoundException, IOException {
		FileInputStream fis = new FileInputStream("test.txt");
		int x = fis.read();
		System.out.println(x);
		
		int y = fis.read();
		System.out.println(y);
		
		int z = fis.read();
		System.out.println(z);
		
		fis.close();
	}

}



















