package org.lxy.utils;

import javax.servlet.http.Cookie;

/**
 * @author menglanyingfei
 * @date 2017-5-20
 */
public class CookieUtils {
	
	public static Cookie findCookieByName(Cookie[] cs, String name) {
		if (cs == null || cs.length == 0) {
			return null;
		}
		for (Cookie c : cs) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		
		return null;
	}
}

















