package com.lxy.basic;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-2-20
 */
public class Main11_HexToDec {
	/**
	 * @param args
	 * 输入:FFFF
	 * 输出:65535
	 * 参考:
	 *     
	 *     #include<iostream>  
		    #include<cmath>  
		    #include<cstring>  
		    using namespace std;  
		    int main()  
		    {  
		        string hex;  
		        long long dec = 0;  
		        cin>>hex;  
		        int len = hex.length();  
		        for(int i=0 ;i<len;i++)  
		        {  
		            if(hex[i] >= 'A')  
		            {  
		                dec += (hex[i] - 'A' + 10)*pow(16,len-1-i);   
		            }  
		            else  
		            {  
		                dec += (hex[i] - '0')*pow(16,len-1-i);  
		            }  
		        }  
		        cout<<dec;  
		        return 0;  
		    }  
	 */
	public static void main(String[] args) {
		String hex;
		long dec = 0;
		Scanner sc = new Scanner(System.in);
		hex = sc.nextLine();
		sc.close();
		int len = hex.length();
		for(int i=0 ;i<len;i++) {  
            if(hex.charAt(i) >= 'A')  
            {  
                dec += (hex.charAt(i) - 'A' + 10) * Math.pow(16,len-1-i);   
            }  
            else  
            {  
                dec += (hex.charAt(i) - '0')*Math.pow(16,len-1-i);  
            }  
        }  
       System.out.println(dec); 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
