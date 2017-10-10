package test;

/**
 * @author menglanyingfei
 * @date 2017-7-13
 */
public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    String s1 = "Hello";
	    String s2 = "Hello";
	    String s3 = "Hellp";
	    s3 = s3.replace('p', 'o');
	    
	    System.out.println(s3);
	    
	    System.out.println(s1 == s2);
	    System.out.println(s1 == s3);
	    
		/*
		System.out.println("Zhejiang University".length);
		
		/*
		int i,j=6;
		System.out.println(i + " " + j);
		/*
		String s1 = "hello";
	    String s2 = "hello";
	    System.out.println(s1 == s2);
		
		/*
	    int temp = (int)3.9;
	    temp %= 2;
		System.out.println(temp);
	    
		/*
	    boolean m = true;
	    if ( m=false )
	      System.out.println("False");
	    else
	      System.out.println("True");
		
		/*
		// String substring(int beginIndex, int endIndex)
		 String a = "Hello";
		 String b=a.substring(0,2); 
		 System.out.println(b);
		 */
//		Scanner sc = new Scanner(System.in);
//		String str = String.format("%02d:", sc.nextInt());
//		System.out.println(str);
		
//		int x=1;
//		float y=2;
//		System.out.println(x/y);
		
//		long test = 012;
//		System.out.println(test);
//		
//		double d = 0x12345678;
//		System.out.println(d);
		
		// 未初始化局部变量
//		String s;
//		System.out.println("s=" + s);
		
//		double i = 0.9239d;
//		System.out.println(i);
		
//		int[] array = new int[10];
//        System.out.println("array的父类是：" + array.getClass().getSuperclass());
//        System.out.println("array的类名是：" + array.getClass().getName());
		
		 System.out.println((double)(10/4*4));
	}

}
