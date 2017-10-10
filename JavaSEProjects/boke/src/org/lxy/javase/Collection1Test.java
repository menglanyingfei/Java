package org.lxy.javase;

import java.util.ArrayList;

/**
 * @author menglanyingfei
 * @date 2017-3-9
 */
public class Collection1Test {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 ArrayList<String> list = new ArrayList<String>();
         list.add("aa");
         list.add("bb");
         list.add("cc");
         list.add("dd");

         // 集合之普通for循环遍历
         for (int i = 0; i < list.size(); i++) {
        	 String value = list.get(i);  
			 System.out.print(value + " ");  // aa bb cc dd 
		 }
         
         System.out.println("\n=====================");        
         // 集合之增强for循环遍历
         for(String string : list) {
             System.out.print(string + " "); // aa bb cc dd
         }
	}
}
