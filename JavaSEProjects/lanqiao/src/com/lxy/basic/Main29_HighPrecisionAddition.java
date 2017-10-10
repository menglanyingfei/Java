package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-13
 */
public class Main29_HighPrecisionAddition {

	/**
	 * 样例输入
		20100122201001221234567890
						  2010012220100122
		样例输出
		20100122203011233454668012
	*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int r = 0;	// r表示进位
        String a, b;
        a = sc.next();
        b = sc.next();
        int A[] = new int[100];
        int B[] = new int[100];
        int C[] = new int[100];
        
        for (int i = a.length(); i > 0; i--) {
                String get1 = a.substring(i - 1, i);
                A[a.length() - i] = Integer.parseInt(get1);
        }
        for (int i = b.length(); i > 0; i--) {
                String get2 = b.substring(i - 1, i);
                B[b.length() - i] = Integer.parseInt(get2);
        }
        for (int i = 0; i < C.length; i++) {
                int m = A[i] + B[i] + r;	// 一个位
                C[i] = m % 10;
                r = m / 10;
        }
        for (int i = C.length - 1; i >= 0; i--) {
                if (C[i] == 0 && r == 0) { 	// 用来舍去前面的零
                        continue;
                }
                r++;
                System.out.print(C[i]);
        }
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
