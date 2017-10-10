package org.lxy.datatype;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Test {
	public static void main(String[] args) {
		int x = 3, y = 2;
		byte b = 4;
		x = x + b;
		System.out.println("隐式转换:");
		System.out.println(x + y);		// 9
		System.out.println(x);			// 7
		
		int m = 126;
        byte n = 4;
        n = (byte) (m + n);				// 注意byte的取值范围为-128~127
		System.out.println("强制转换:");
		System.out.println(n);			// 结果不是130, 而是-126
	}
}