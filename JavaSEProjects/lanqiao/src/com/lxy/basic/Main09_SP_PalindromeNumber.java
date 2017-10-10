package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-12
 */
public class Main09_SP_PalindromeNumber {
	/**
	 * 五位和六位的回文数, 满足各位数字之和等于输入数
	 * 输入:52
	 * 输出:
	 * 899998
		989989
		998899
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		sc.close();
		/*
		 * 错误做法:
		int a, b, c, d, e;
		for (int i = 1000; i < 10000; i++) {
			a = i / 1000;
			b = i / 100 % 10;
			c = i / 10 % 10;
			d = i % 10;
			if (a == d && b == c && a+b+c+d == input) {
				System.out.println(i);
			}
		}		
		for (int i = 10000; i < 100000; i++) {
			a = i / 10000;
			b = i / 1000 % 10;
			c = i / 100 % 10;
			d = i / 10 % 10;
			e = i / 10;
			if (a == e && b == d && a+b+c+d+e == input) {
				System.out.println(i);
			}			
		}
		*/
		
		/* 参考
		 * int a(int n) // 求出5位数和6位数中的回文数函数   
			{  
		    int i,j,sum,temp,len;  
		    int a,b,c;  
		    for(i=10000;i<1000000;++i)  
		    {  
		        sum=0;  
		        temp=i;  
		        len=0;  
		        while(temp!=0)  
		        {  
		            sum=sum*10+temp%10;  
		            temp=temp/10;  
		            len++;//累计位数以此判断是5位数还是6位数   
		        }  
		        if(sum==i)//先把回文数求出来，下面再来比较各位数字之和是否等于n   
		        {  
		            a=i%10;//个位   
		            b=i/10%10;//十位  
		            c=i/100%10;//百位           
		            if(5==len)  
		            {  
		                if(n==(2*a+2*b+c))  
		                {  
		                    printf("%d\n",i);  
		                 }   
		            }  
		            if(6==len)  
		            {  
		                if(n==(2*a+2*b+2*c))  
		                {  
		                    printf("%d\n",i);   
		                }  
		            }  
		        }  
		    }  
		}  
		 */
		int sum, temp, len;  
	    int a,b,c;  
	    for(int i=10000;i<1000000;++i)  
	    {  
	        sum=0;  
	        temp=i;  
	        len=0;  
	        while(temp!=0)  
	        {  
	            sum=sum*10+temp%10;  
	            temp=temp/10;  
	            len++;//累计位数以此判断是5位数还是6位数   
	        }  
	        if(sum==i)//先把回文数求出来，下面再来比较各位数字之和是否等于n   
	        {  
	            a=i%10;//个位   
	            b=i/10%10;//十位  
	            c=i/100%10;//百位           
	            if(5==len)  
	            {  
	                if (input==(2*a+2*b+c))  
	                {  
	                    System.out.println(i);  
	                 }   
	            }  
	            if(6==len)  
	            {  
	                if(input==(2*a+2*b+2*c))  
	                {  
	                	System.out.println(i);   
	                }  
	            }  
	        }  
	    }	
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
