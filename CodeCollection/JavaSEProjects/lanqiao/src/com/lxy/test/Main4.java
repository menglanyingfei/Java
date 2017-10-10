package com.lxy.test;

import java.util.*;

public class Main4 {

	/*
	 * 10
	 * 55
	 * 
	 * 22
	 * 7704
	 * 
	 * 55
	 * 2091
	 * 
	 * 99999
	 * 6415
	 */
	// 参考
	/*
	 * 计算时间超长
	 * uint64_t Fibonacci(unsigned char n)
		{
		    if( n == 0 ) return 0;
		    if( n == 1 ) return 1;
		    return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
		
		改进（递推）必须加上这个方法--直接计算余数往往比先算出原数再取余简单！！！
		uint64_t Fibonacci(unsigned char n)
		{
		    if( n == 0 ) return 0;
		    if( n == 1 ) return 1;
		    uint64_t fn, fnn = 1, fnnn = 0;
		    for(int i = 2; i <= n; i ++)
		    {
		        fn = fnn + fnnn;
		        fnn = fn;
		        fnnn = fnn;
		    }
		    return fn;
		}		
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Integer n = input.nextInt();
		Integer sum = fibonacci(n);
		System.out.println(sum);
	}

	private static Integer fibonacci(Integer n) {
		 if( n == 0 ) return 0;
		 if( n == 1 ) return 1;
		 Integer fn = 1, fnn = 1, fnnn = 0;
		 for(int i = 2; i <= n; i ++)
	     {
			fnn = fn % 10007;
	        fn = (fnn + fnnn) % 10007;
	        fnnn = fnn % 10007;
	     }
	     return fn;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
