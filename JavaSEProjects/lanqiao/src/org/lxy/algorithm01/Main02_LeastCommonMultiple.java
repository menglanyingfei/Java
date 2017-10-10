package org.lxy.algorithm01;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-14
 */
public class Main02_LeastCommonMultiple {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);  
        long n=sc.nextLong();  
        long num;  
        if(n<=2) {  
            num=2;  
        }else if(n%2==1){  
            num=n*(n-1)*(n-2);  
        }else if(n%3==0){  
            num=(n-1)*(n-2)*(n-3);  
        }else{  
            num=n*(n-1)*(n-3);  
        }  
        System.out.println(num);  
        sc.close();  
	}
}
