package org.lxy.chario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Demo {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		 BufferedReader br =                                     //高效的用指定的编码表读
	       new BufferedReader(new InputStreamReader(new FileInputStream("UTF-8.txt"), "GBK"));
         BufferedWriter bw =                                     //高效的用指定的编码表写
           new BufferedWriter(new OutputStreamWriter(new FileOutputStream("GBK.txt"), "GBK"));
         int ch;
         while((ch = br.read()) != -1) {
             bw.write(ch);
         }

         br.close();
         bw.close();
	}
}
