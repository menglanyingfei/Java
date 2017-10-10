package test;

/**
 * @author menglanyingfei
 * @date 2017-7-14
 */
public class VarParameter {

	/**
	 * @param args
	 * 可变参数的用法
	 */
	public static int sum(int... numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(sum(1, 2, 3));
	}

}
