package com.lxy.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author menglanyingfei
 * @date 2017-3-6
 * 别人的程序!
 */
public class Main19_TanXin {
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int len = Integer.parseInt(reader.readLine());
		char[] s = reader.readLine().toCharArray();
		reader.close();
		if (palindrome(s, 0, len - 1)) {
			System.out.println(cnt);
		} else {
			System.out.println("Impossible");
		}
	}
	
	private static int cnt = 0;
	private static boolean haveMiddle = false;
	
	private static boolean palindrome(char[] s, int a, int b) {
		if (b <= a) {
			return true;
		}
        // 从最后的位置开始遍历字符串
		for (int i = b; i > a; i--) {
			if (s[a] == s[i]) {
				exchangeTo(s, i, b);
				cnt += getExchangeTimes(i, b);
				return palindrome(s, a + 1, b - 1);
			}
		}
        // 如果没有出现过中间字符
		if (!haveMiddle) {
			haveMiddle = true;
			cnt += getExchangeTimes(a, s.length / 2);
			return palindrome(s, a + 1, b);
		}
		return false;
	}
	
	private static int getExchangeTimes(int a, int b) {
		return b - a;
	}
	
	private static void exchangeTo(char[] s, int a, int b) {
		char temp = s[a];
		for (int i = a; i < b; i++) {
			s[i] = s[i + 1];
		}
		s[b] = temp;
	}
}
