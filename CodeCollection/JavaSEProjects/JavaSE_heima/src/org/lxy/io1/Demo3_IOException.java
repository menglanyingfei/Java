package org.lxy.io1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author menglanyingfei
 * @date 2017-4-1
 */
public class Demo3_IOException {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("x.txt");
			fos = new FileOutputStream("y.txt");
			
			int b;
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
		} finally {
			try {
				if (fis != null)
					fis.close();
			} finally {
				if (fos != null)
					fos.close();
			}
		}
		
	}

}



















