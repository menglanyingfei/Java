package com.netease.course;

import java.util.HashMap;
import java.util.Map;

import com.netease.course.entity.User;

/**
 * token user数据维护静态工具类
 * 
 * @author 15072
 * 
 */
public class TokenUserData {

	private TokenUserData() {
	}

	// 存储数据的对象
	private static Map<String, User> dataMap = new HashMap<>();

	/**
	 * 新增令牌存储
	 * 
	 * @param token
	 * @param user
	 */
	public static void addToken(String token, User user) {
		dataMap.put(token, user);
	}

	/**
	 * 验证令牌，如果令牌有效返回User对象，否则返回空
	 * 
	 * @param token
	 * @return
	 */
	public static User validateToken(String token) {
		return dataMap.get(token);
	}

	/**
	 * 移除token项
	 * 
	 * @param token
	 */
	public static void removeToken(String token) {
		dataMap.remove(token);
	}
}