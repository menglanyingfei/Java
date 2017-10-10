package com.lxy.basic;
/**
 * @author menglanyingfei
 * @date 2017-2-6
 */
public class Main02 {

	/**
	 * @param args
	 */
	// 需求：输出32行，按从小到大的顺序每行一个长度为5的01串
	// 方法：使用5层循环 
	/*
	 * 参考程序：
	 * // 方法二：五层循环法
	#include <iostream>
	using namespace std;
	int main()
	{
	  int a,b,c,d,e;
	  for(a=0;a<2;++a)
	    for(b=0;b<2;++b)
	      for(c=0;c<2;++c)
	        for(d=0;d<2;++d)
	          for(e=0;e<2;++e)
	            cout<<a<<b<<c<<d<<e<<endl;
	  return 0;
	}
	 */
	// 结果：
	/*
	00000  0
	00001  1
	00010  2
	00011  3
	00100  4
	00101  5
	*/
	public static void main(String[] args) {
		Integer a, b, c, d, e;
		for (a = 0; a < 2; a++)
			for (b = 0; b < 2; b++)
				for (c = 0; c < 2; c++)
					for (d = 0; d < 2; d++)
						for (e = 0; e < 2; e++) {
							System.out.println(a.toString() + b.toString() + c.toString() + d.toString() + e.toString());
						}
							
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
