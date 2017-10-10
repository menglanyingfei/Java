package org.lxy.foreach;
/**
 * @author menglanyingfei
 * @date 2017-4-7
 */
public class L1_foreach {
	public static void main(String[] args) {
	    int[] a = {0,2,5,3};  
	    int nSum = 0;  
	    for(int n : a)	//求和  
	    {  
	         nSum += n;  
	         n = 1; //这样的操作是不会改变数组a中的值的, 因为这里的n是“只读的”  
	    }  
	    System.out.println(nSum);
	}
}
