package org.lxy.set;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Test01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);            //创建键盘录入对象
        System.out.println("请输入一行字符串:");
        String line = sc.nextLine();                    			//将键盘录入的字符串存储在line中
        char[] arr = line.toCharArray();               		 //将字符串转换成字符数组
        TreeSet<Character> ts = new TreeSet<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                //int num = c1.compareTo(c2);
                int num = c1 - c2;                  // 自动拆箱
                return num == 0 ? 1 : num;
            }
        });

        for(char c : arr) {
            ts.add(c);
        }

        for(Character ch : ts) {
            System.out.print(ch);
        }
	}

}
