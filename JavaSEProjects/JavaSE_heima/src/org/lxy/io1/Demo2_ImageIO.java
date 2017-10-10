package org.lxy.io1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author menglanyingfei
 * @date 2017-4-1
 */
public class Demo2_ImageIO {

	/**
	 * 图片的加密
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("zi2.jpg"));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("zi3.jpg"));
		
		int b;
		while ((b = bis.read()) != -1) {
			bos.write(b ^ 123);
		}
		bis.close();
		bos.close();
	}

}

















