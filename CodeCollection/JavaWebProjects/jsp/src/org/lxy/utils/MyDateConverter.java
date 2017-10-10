package org.lxy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

/**
 * 字符串转换日期类
 * @author menglanyingfei
 * @date 2017-2-6
 */
public class MyDateConverter implements Converter{
	/**
	 * 字符串转换成日期
	 */
	public Object convert(@SuppressWarnings("rawtypes") Class clazz, Object obj) {
		// 把输入的字符串，转换成日期类型，返回
		String dDStringate = (String) obj;
		// 把字符串转换成日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = null;
		Date date;
		try {
			date = sdf.parse(dDStringate);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException("转换日期错误");
		}
		
		return date;
	}

}
