package org.lxy.generictype;

/**
 * @author menglanyingfei
 * @date 2017-5-23
 */
public class Rational extends Number implements Comparable<Rational> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5678662443900005825L;

	private long numerator = 0;
	private long denominator = 1;

	public Rational() {
		this(0, 1);
	}

	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator > 0) ? 1 : -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}

	// greatest common divisor
	private static long gcd(long n, long d) {
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;

		for (int k = 1; k <= n1 && k <= n2; k++) {
			if (n1 % k == 0 && n2 % k == 0) {
				gcd = k;
			}
		}

		return gcd;
	}

	public long getNumerator() {
		return numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public Rational add(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator
				* secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}

	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n, d);
	}
	
	
	@Override
	public String toString() {
		if (denominator == 1) {
			return numerator + "";
		} else {
			return numerator + "/" + denominator;
		}
	}

	@Override
	public int compareTo(Rational o) {
		return 0;
	}
	
	@Override
	public int intValue() {
		return 0;
	}

	@Override
	public long longValue() {
		return 0;
	}

	@Override
	public float floatValue() {
		return 0;
	}

	@Override
	public double doubleValue() {
		return 0;
	}

}
