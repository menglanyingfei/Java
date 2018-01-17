package day_1_8;

public class Demo {

	public static void main(String[] args) {
         /*
             Java基本数据类型复习
         */
		 int i = '我';

		 System.out.println(i); // 25105
		 char c = 65535;
		 System.out.println(c); // 无法确定的字符
         // int数范围: 0----65535
//		 char a = 65536;

		 byte b = 5;
		 // 数据类型不匹配, byte = int
//		 byte m = b + 6;

		 short d = 5;
		 short e = 6;
		 // 数据类型不匹配, short = int
//		 short n = d + e;
	}
}
