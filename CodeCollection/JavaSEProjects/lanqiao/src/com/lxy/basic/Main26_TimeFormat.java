package com.lxy.basic;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-3-7
 */
public class Main26_TimeFormat {
	public static void main(String[] args) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();  
        map.put(0, "zero");  
        map.put(1, "one");  
        map.put(2, "two");  
        map.put(3, "three");  
        map.put(4, "four");  
        map.put(5, "five");  
        map.put(6, "six");  
        map.put(7, "seven");  
        map.put(8, "eight");  
        map.put(9, "nine");  
        map.put(10, "ten");  
        map.put(11, "eleven");  
        map.put(12, "twelve");  
        map.put(13, "thirteen");  
        map.put(14, "fourteen");  
        map.put(15, "fifteen");  
        map.put(16, "sixteen");  
        map.put(17, "seventeen");  
        map.put(18, "eighteen");  
        map.put(19, "nineteen");  
        map.put(20, "twenty");  
        map.put(30, "thirty");  
        map.put(40, "forty");  
        map.put(50, "fifty");  
          
        Scanner sc = new Scanner(System.in);  
        int h = sc.nextInt();  
        int m = sc.nextInt();  
        sc.close();  
          
        StringBuffer sb = new StringBuffer();  
          
        //h>=0 h<24  
        if(h <= 20){  
            sb.append(map.get(h));  
        }else{  
            int temp1 = h/10*10;  
            int temp2 = h%10;  
            sb.append(map.get(temp1));  
            sb.append(" ");  
            sb.append(map.get(temp2));  
        }  
        sb.append(" ");  
          
        if(m == 0){  
            sb.append("o'clock");  
        }else if(m <= 20 || m==30 || m==40 || m==50){  
            sb.append(map.get(m));  
        }else{  
            int temp1 = m/10*10;  
            int temp2 = m%10;  
            sb.append(map.get(temp1));  
            sb.append(" ");  
            sb.append(map.get(temp2));  
        }  
        System.out.println(sb);  
	}
}
