package org.lxy.parameter_transfer;
/**
 * @author menglanyingfei
 * @date 2017-2-10
 */
public class Test2_Array {
	/**
	 * 引用数据类型的值传递
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};						// arr[1] = 2
        change(arr);
        System.out.println(arr[1]);					// arr[1] = 4
	}

	public static void change(int[] arr) {	// 1, 4, 3, 8, 5
		for(int x=0; x<arr.length; x++) {
            if(arr[x]%2==0) {
                arr[x]*=2;
            }
        }
	}
}
