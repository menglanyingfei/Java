package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		int count = 12;
		String number = String.format("%04d", count);
		System.out.println(number);
		
		System.out.println("============");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		System.out.println(sdf.format(date));
//		System.out.println(sdf.format(date).replaceAll("-", ""));
	}
}
