package com.lxy.basic;

import java.util.Scanner;


/**
 * @author menglanyingfei
 * @date 2017-2-17
 */
public class Main10_ToHEX {
	/**
	 * @param args
	 * 输入:30
	 * 输出:1E
	 * 参考
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//        System.out.println("请出入一个十进制数");
        int num = sc.nextInt();
        sc.close();
        System.out.println(Integer.toHexString(num).toUpperCase());// java自带的转换十六进制方法
	}
}
