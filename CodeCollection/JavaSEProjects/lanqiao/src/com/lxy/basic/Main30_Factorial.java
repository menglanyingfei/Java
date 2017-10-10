package com.lxy.basic;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-13
 */
public class Main30_Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*int[] arr = new int[1000];  
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();  
        sc.close();      
        
        arr[0] = 1;  
        for (int i = 2; i <= n; i++) {  
            int r = 0;  
            for (int j = 0; j < arr.length; j++) {  
                int temp = arr[j] * i + r;  
                arr[j] = temp % 10;  
                r = temp / 10;  
            }  
        }  
        boolean begin = false;  
        for (int i = arr.length - 1; i >= 0; i--) {  
            if (begin) {  
                System.out.print(arr[i]);  
                continue;  
            }  
            if (arr[i - 1] != 0) {  
                begin = true;  
            }  
        }  */
		
		Scanner scanner = new Scanner(System.in);  
		  
        while (scanner.hasNext()) {  
            int n = scanner.nextInt();  
  
            BigDecimal num = BigDecimal.ONE;  
            for (int i = 2; i <= n; i++) {  
                num = num.multiply(BigDecimal.valueOf(i));  
            }  
            System.out.println(num);  
        }  
	}

}
