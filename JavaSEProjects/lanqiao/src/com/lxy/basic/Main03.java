package com.lxy.basic;

import java.util.*;

/**
 * @author menglanyingfei
 * @date 2017-2-6
 */
public class Main03 {

	/**
	 * @param args
	 */
	// 字母的序号与两个坐标的差的绝对值有关。 
	/*
	 *     参考程序：
	 *     #include<iostream>  
		    #include<cmath>  
		    using namespace std;  
		    int main()  
		    {  
		        int n;      //n为行  
		        int m;      //m为列   
		        cin>>n>>m;  
		        char a='A'; //作为输出基数   
		        for(int i=0;i<n;i++)  
		        {  
		            for(int j=0;j<m;j++)  
		            {  
		                cout<<char(a+abs(i-j));  
		            }   
		            cout<<endl;  
		        }   
		        return 0;  
		    }   
	 */
	public static void main(String[] args) {
		int n, m;  // n为行,m为列
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		m = input.nextInt();
		input.close();
		char a = 'A'; // 作为输出基数
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print((char) (a + Math.abs(i-j)));
			}
			System.out.println();
		}
	}

}
