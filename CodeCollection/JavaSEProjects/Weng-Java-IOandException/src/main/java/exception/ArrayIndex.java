package exception;

//import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-9-3
 */
public class ArrayIndex {

	/**
	 * @param args
	 * 捕捉异常
	 */
	public static void f() {
		int[] a = new int[10];
		a[10] = 10;
		System.out.println("f()");
	}
	
	public static void main(String[] args) {
		/*int[] a = new int[10];
		int idx;
		Scanner in = new Scanner(System.in);
		idx = in.nextInt();
		try {
			a[idx] = 10;
			System.out.println("hello");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Caught");
		}*/
		
		try {
			f();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("finally");
		}
	}

}
