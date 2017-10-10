package org.lxy.customer.utils;

import java.util.UUID;

/**
 * @author menglanyingfei
 * @date 2017-5-13
 */
public class IdUtils {
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	/*public static void main(String[] args) {
		System.out.println(getUUID());
	}*/
}
