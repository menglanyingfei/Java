package exer;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class Main03_Distance {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Scanner in = new Scanner(System.in);
		String str;
		int cnt = 0;
		
		while (true) {
			str = in.next();
			if (str.equals("###")) {
				break;
			} else {
				map.put(str, ++cnt);
			}
		}
		int[][] arr = new int[cnt][cnt];
		for (int i = 0; i < cnt; i++) {
			for (int j = 0; j < cnt; j++) {
				arr[i][j] = in.nextInt();
			}
		}
		
		String place1 = in.next();
		String place2 = in.next();
		int num1 = map.get(place1);
		int num2 = map.get(place2);
		System.out.println(arr[num1 - 1][num2 - 1]);
	}
	
}

















