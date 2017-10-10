package com.netease.course.utils;


/**
 * 字符串实用工具类
 * 
 * @author Administrator
 *
 */
public class StringUtil {

	private StringUtil() {}
	/**
	 * 是否为空
	 * 
	 * @param str
	 * @return null或空串或全为空白字符的串
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}

		if (str.trim().length() == 0) {
			return true;
		}

		return false;
	}
}