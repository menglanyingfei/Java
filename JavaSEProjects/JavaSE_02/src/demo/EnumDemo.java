package demo;
/**
 * @author menglanyingfei
 * @date 2017-6-14
 */

enum AccountType {
	SAVING, FIXED, CURRENT;
	private AccountType() {
		System.out.println("It is a account type");
	}
}

public class EnumDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(AccountType.FIXED);
		// 运行结果:
		/*
		 * It is a account type
			It is a account type
			It is a account type
			FIXED
		 * 
		 */
	}

}
