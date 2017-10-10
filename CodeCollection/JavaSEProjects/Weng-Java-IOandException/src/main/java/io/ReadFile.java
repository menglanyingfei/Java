package io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author menglanyingfei
 * @date 2017-9-11
 * 中文
 */
public class ReadFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
//			BufferedReader in = new BufferedReader(new InputStreamReader(
//					new FileInputStream("src/main/java/io/ReadFile.java")));
			BufferedReader in = new BufferedReader(new InputStreamReader(
					new FileInputStream("test.txt"), "utf8"));
			String line;
			while ((line = in.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
