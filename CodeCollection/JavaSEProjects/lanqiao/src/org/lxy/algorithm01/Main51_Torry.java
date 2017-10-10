package org.lxy.algorithm01;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-18
 */
public class Main51_Torry {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();  
        a.add(2);  
        for (int i = 3; i <= 100000; i += 2) {  
            int j;  
            for (j = 3; j <= Math.sqrt(i); j++) {  
                if (i % j == 0)  
                    break;  
            }  
            if (j > Math.sqrt(i)) {  
                a.add(i);  
            }  
        }  
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();  
        int s = 1;  
        for (int i = 0; i < n; i++) {  
            s = (s * a.get(i)) % 50000;  
        }  
        System.out.println(s); 
	}

}
