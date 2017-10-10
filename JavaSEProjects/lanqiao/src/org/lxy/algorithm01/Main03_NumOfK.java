package org.lxy.algorithm01;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-14
 * ???
 */
public class Main03_NumOfK {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
        int k = sc.nextInt();  
        int l = sc.nextInt();  
        int num[][] = new int[l][k];  
        for (int i = 0; i < k; i++) {  
            num[0][i]=1;  
        }  
          
        for (int i = 1; i < l; i++) {  
            for (int j = 0; j < k; j++) {  
                for (int x = 0; x < k; x++) {  
                    if (x!=j-1&&x!=j+1) {  
                        num[i][j] += num[i-1][x];  
                        num[i][j] %= 1000000007;  
                    }  
                }  
            }  
        }  
          
        int output = 0;  
        for (int i = 1; i < k; i++) {  
            output += num[l-1][i];  
            output %=1000000007;  
        }  
        System.out.println(output); 
	}
}
