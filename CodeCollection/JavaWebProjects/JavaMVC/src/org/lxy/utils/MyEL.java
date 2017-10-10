package org.lxy.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
//%E6%9D%8E%E6%98%9F%E9%98%B3
public class MyEL {
	
	public static String myDecode(String str) {
		try {
			return URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
