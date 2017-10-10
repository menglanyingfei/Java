package exer;

import java.util.Scanner;

/**
 * @author menglanyingfei
 * @date 2017-7-13
 */
public class Main01_Class {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Fraction a = new Fraction(in.nextInt(), in.nextInt());
		Fraction b = new Fraction(in.nextInt(), in.nextInt());

		a.print();
		b.print();

		a.plus(b).print();
		a.multiply(b).plus(new Fraction(5, 6)).print();
		a.print();
		b.print();

		in.close();
	}
}

class Fraction {
	private int a;
	private int b;

	Fraction(int a, int b) {
		this.a = a;
		this.b = b;
	}

	double toDouble() {
		return 1.0 * a / b;
	}

	Fraction plus(Fraction r) {
		int n = r.a * b + r.b * a;
		int fm = r.b * b;
		return new Fraction(n, fm);
	}

	Fraction multiply(Fraction r) {
		int n = r.a * a;
		int fm = r.b * b;
		return new Fraction(n, fm);
	}

	// Maximum common divisor
	public int Simplify(int up, int down) {
		int min;
		int t = 1;
		min = (up < down) ? up : down;
		for (int i = 1; i <= min; i++) {
			if (up % i == 0 && down % i == 0)
				t = i;
		}

		return t;
	}

	void print() {
		int t = Simplify(a,b);  
        int fz = a/t;  
        int fm = b/t;  
        if (fm==fz)  
            System.out.println(fm/fz);  
        else  
            System.out.println(fz+"/"+fm);  
	}
}

