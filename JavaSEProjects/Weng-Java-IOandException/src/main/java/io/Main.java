package io;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author menglanyingfei
 * @date 2017-9-11
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("hello world");
		byte[] buf = new byte[10];
		for (int i = 0; i < buf.length; i++) {
			buf[i] = (byte) i;
		}

		try {
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream("a.dat")));
			out.write(buf);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
