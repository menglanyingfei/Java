package com.lxy.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-13
 */
// 利用Java API中的AarryList可以帮助我们迅速解决掉此问题，另还用到了Collections的sort方法。
public class Main28_HuffumanTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();  
        ArrayList<Integer> a = new  ArrayList<Integer>();  
        for(int i=0; i<n; i++) {  
            a.add(sc.nextInt());  
        }  
        sc.close();  
        int sum = 0;  
        while (a.size() != 1) {  
            Collections.sort(a);  
            int m = a.get(0) + a.get(1);  
            sum += m;  
            a.remove(0);  
            a.remove(0);  
            a.add(m);  
        }  
          
        System.out.println(sum);  
	}

}
