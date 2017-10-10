package org.lxy.otherio;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 内存输出流
 * @author menglanyingfei
 * @date 2017-4-13
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("test.txt");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int b;
        while((b = fis.read()) != -1) {
            baos.write(b);
        }

        byte[] newArr = baos.toByteArray();               //将内存缓冲区中所有的字节存储在newArr中
        System.out.println(new String(newArr));
        
        //System.out.println(baos);
        fis.close();
	}
}























