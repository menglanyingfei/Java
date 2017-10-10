package test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author menglanyingfei
 * @date 2017-7-15
 */
public class HashMapTest {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "haha");
		map.put(2, "happy");
		map.put(3, "good");
		map.put(1, "ha");
		map.put(5, "good");
		
		System.out.println(map);
		// {1=ha, 2=happy, 3=good, 5=good}
	}
}
