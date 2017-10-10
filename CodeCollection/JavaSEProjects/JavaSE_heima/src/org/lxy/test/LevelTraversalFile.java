package org.lxy.test;

import java.io.File;

/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class LevelTraversalFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File dir = Test1.getDir();
		printLev(dir, 0);
	}

	public static void printLev(File dir, int lev) {
		File[] subFiles = dir.listFiles();
		for (File subFile : subFiles) {
			for (int i = 0; i <= lev; i++) {
				System.out.print("\t");
			}
			System.out.println(subFile);
			if (subFile.isDirectory()) {
				printLev(subFile, lev + 1);
			}
		}
	}
}















