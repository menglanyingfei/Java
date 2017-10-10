package test;

/**
 * @author menglanyingfei
 * @date 2017-7-9
 */
public class Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * int[][] m = {{1,4,7},{2,5,8},{3,6,9},}; int i, k=2; for ( i=0; i<3;
		 * i++ ) { System.out.print(m[k][i]); }
		 */

		/*
		 * String str = String.valueOf(320); int num = str.length();
		 * System.out.println(num);
		 */

		/*
		 * int a = 3; int b = 1; if ( a = b ) System.out.println("="); else
		 * System.out.println("!=");
		 */

		/*
		 * int x=1, y=12; System.out.printf("%d", y*x++);
		 */

		/*
		 * int i=0; while ( true ) { if ( ++i > 10 ) { //System.out.println(i);
		 * break; } //System.out.print(i + " "); } System.out.println(i);
		 */

		char a[][] = new char[3][3];
		for (int I = 0; I < a.length; I++)
			for (int j = 0; j < a[I].length; j++)
				if (I >= j)
					a[I][j] = '*';
				else
					a[I][j] = ' ';
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < 3; j++)
				System.out.print(a[k][j] + "\t");
			System.out.println();
		}
	}

}
