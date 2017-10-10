package test;

/**
 * @author menglanyingfei
 * @date 2017-6-26
 */
public class ExceptionTest {
	static String a[] = { "123", "abc", null };

	static int arr[] = new int[5]; 
	
	public static void main(String args[]) {
		/*
	    boolean m = true;
	    if ( m=false )
	      System.out.println("False");
	    else
	      System.out.println("True"); // pass
	    */
		String s1 = "hello";
	    String s2 = "hello";
	    System.out.println(s1 == s2); // true
	    System.out.println(arr[0]); // 初始化值: 0
	    
		for (int i = 0; i < 3; i++) {
			try {
				int x = Integer.parseInt(a[i]);
				System.out.print("Result: " + x + " ");
			} catch (NullPointerException e) {
				System.out.print("error null：" + " ");
			} catch (NumberFormatException e) {
				System.out.print("error ：abc" + " ");
			} finally {
				System.out.print("In " + i + "th loop\n" + " ");
			}
		}
	}
}
