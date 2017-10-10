package org.lxy.demo_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author menglanyingfei
 * @date 2017-2-27
 */
public class Demo1_SimpleDateFormat {
	/**
	 * @param args
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		String birthday = "1997年08月15日";
		String today = "2017年2月27日";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		
		Date d1 = sdf.parse(birthday);
		Date d2 = sdf.parse(today);
		long time = d2.getTime() - d1.getTime();
		System.out.println(time / 1000 / 60 / 60 / 24);
		System.out.println(time / 1000 / 60 / 60 / 24 / 365);
	}
}
