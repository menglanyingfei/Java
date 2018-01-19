package com.wtu.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	// 将字符串转换成为Date对象
	public static Date strToDate(String date,String style){
		
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

    // 将Date对象转为字符串对象 xxxx-xx-xx (10位字符)
    public static String dateToStr(Date date) {
	    return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}




















