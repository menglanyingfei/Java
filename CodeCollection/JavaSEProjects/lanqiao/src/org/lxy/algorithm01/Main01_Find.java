package org.lxy.algorithm01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-14
 */
public class Main01_Find {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();  
        ArrayList<Integer> alist = new ArrayList<Integer>(n);  
        int[] a = new int[n];  
        for(int i=0 ; i<n ; i++){  
            a[i] = sc.nextInt();  
        }  
        int m =sc.nextInt();  
        int[] l = new int[m];  
        int[] r = new int[m];  
        int[] k = new int[m];  
        for(int i=0 ; i<m ; i++){  
            l[i] = sc.nextInt();  
            r[i] = sc.nextInt();  
            k[i] = sc.nextInt();  
              
        }  
        
        for(int i=0 ; i<m ; i++){      // 以下代码重复执行m次数  
            for(int j=l[i]-1 ; j<=(r[i]-1) ; j++ ){   
                alist.add(a[j]);            //将a中第l个到第r个元素添加到alist  
            }  
            Collections.sort(alist);     //将alist排序  
            System.out.println(alist.get(r[i]-l[i]-k[i]+1));   //输出第k大的数  
            alist.clear();   //清空alist  
        }  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
