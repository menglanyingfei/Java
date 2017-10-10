package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-21
 */
public class Main16_PrimeNumber {
	/**
	 * @param args
	 * 判断质数
	 * 样例输入
		3 10
		样例输出
		3=3
		4=2*2
		5=5
		6=2*3
		7=7
		8=2*2*2
		9=3*3
		10=2*5
	 */
	public static void main(String[] args) {
		        Scanner sc = new Scanner(System.in);
		        int n1 = sc.nextInt();
		        int n2 = sc.nextInt();
		        int[] a = new int[n2-n1+1];
		        if(n1==n2)
		            a[0] = n1;
		        else
		            for(int i=n1,j=0;i<=n2;i++,j++)
		                a[j] = i;
		        for(int i=0;i<a.length;i++){
		            StringBuffer st = new StringBuffer(a[i]+"=");
		            int z = 2,tmp = a[i];
		            while(z<=tmp){
		                if(tmp%z==0){
		                    if(st.charAt(st.length()-1)!='=')st.append("*");
		                    st.append(z);
		                    tmp = tmp/z;
		                    z = 2;
		                }else
		                    z++;
		            }
		            System.out.println(st);
		        }
		    }
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


