package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-12
 */
public class Main11_TimeConvert {

	/**
	 * @param args
	 * 待定?
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		String now = null;
		String str = in.nextLine();
		String judge = new String("END");
		String right = new String("$GPRMC");
		while (!str.equals(judge)) // 输入为END ，结束输入
		{
			String[] ss = str.split(",");// 以逗号为分割 把str分割为若干字符串 放入数组ss

			if (!ss[0].equals(right))// 如果第一个逗号以前的部分不为所要求，读入下一列，结束这一行处理
			{
				str = in.nextLine();
				continue;
			}
			int i, result = 0;
			char ch;

			ch = str.charAt(1);// 从第二个字符开始做异或，存入result
			for (result = str.charAt(1), i = 2; ch != '*'; i++, ch = str
					.charAt(i)) {
				ch = str.charAt(i);
				result ^= (int) ch;
			}
			result %= 65536;
			String num = str.substring(i + 1, i + 3);// 取*后面两位

			char state = ss[2].charAt(0);
			num = num.toLowerCase();// 转化为小写
			if (num.equals(Integer.toHexString(result)) && state == 'A')// 如果相同
				now = ss[1];
			str = in.nextLine();
		}
		if (now == null)
			System.exit(0);
		String hh = now.substring(0, 2);
		String mm = now.substring(2, 4);
		String ss = now.substring(4, 6);
		int hour = Integer.parseInt(hh);
		hour = (hour + 8) % 24;
		if (hour < 10)
			System.out.print(0);
		System.out.println(hour + ":" + mm + ":" + ss);// 输出时间
	}

}
