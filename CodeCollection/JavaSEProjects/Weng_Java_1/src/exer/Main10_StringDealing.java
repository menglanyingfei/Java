package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-12
 */
public class Main10_StringDealing {
	// It's great to see you here.
	// 4 5 2 3 3 4
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String str = in.nextLine();
		String[] ss = str.split(" ");// 以空格为间隔把str分割为若干个字符串 放入数组ss
		int i;
		for (i = 0; i < ss.length - 1; i++)
			if (ss[i].length() != 0)// 长度为0的字符串不输出
			{
				System.out.print(ss[i].length() + " ");
			}

		if (ss[i].length() != 1) // 最后一位如果只有.不输出 且最后一位无空格
			System.out.println(ss[i].length() - 1);

	}
}
