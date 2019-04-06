/**
 * RationalNumber Class
 * @author Josiah Moore
 */

public class RationalNumber {

	private int numerator;
	private int denominator;
	
	//Constructors
	
	public RationalNumber() {
		numerator = 0;
		denominator = 1;
	}
	
	public RationalNumber(int num, int dem) {
		numerator = num;
		denominator = dem;
		simplify();
	}
	
	public RationalNumber(RationalNumber other) {
		numerator = other.numerator;
		denominator = other.denominator;
		simplify();
	}
	
	//Access & Setter Methods
	
	public RationalNumber copy() {
		simplify();
		return new RationalNumber(numerator,denominator);
	}
	
	public void setNumerator(int num) {
		numerator = num;
		simplify();
	}
	
	public void setDenominator(int dem) {
		denominator = dem;
		simplify();
	}	
	
	public int getNumerator() {
		return numerator;
	}
	
	public int getDenominator() {
		return denominator;
	}
	
	//Display Methods
	
	public String toString() {
		String str = numerator + "/" + denominator;
		return str;
	}
	
	public double toDecimal() {
		double decimal = (double)numerator/denominator;
		return decimal;
	}
	
	//Simplifying Methods
	
	/**
	 * This method reduces the fraction by calling the GCD method
	 * and then makes sure both that the denominator is not negative,
	 * and that both the numerator and denominator aren't redundantly negative
	 */
	public void simplify() {
		if (numerator != 0) {
			int gcd = gcd(numerator,denominator);
			numerator = numerator / gcd;
			denominator = denominator / gcd;
		}
		makePositive();
	}
	
	/**
	 * A private method that is called through the simplify method to fix negative signs
	 */
	private void makePositive() {
		if ((numerator < 0 && denominator < 0) || denominator < 0) {
			numerator = -numerator;
			denominator = -denominator;
		}
	}
	
	/**
	 * A private method that is called through the simplify method to get the GCD
	 * using Euclid's Algorithm
	 */
	private int gcd(int x, int y) {
		if (y == 0)
			return x;
		else
			return gcd(y, x % y);
	}
	
	//Operation Methods
	
	public RationalNumber add(RationalNumber other) {
		int n,d;
		
		n = (numerator * other.denominator) + (other.numerator * denominator);
		d = (denominator * other.denominator);
		
		return new RationalNumber(n,d);
	}
	
	public RationalNumber subtract(RationalNumber other) {
		int n,d;
		n = (numerator * other.denominator) - (other.numerator * denominator);
		d = (denominator * other.denominator);
		
		return new RationalNumber(n,d);
	}
	
	public RationalNumber multiply(RationalNumber other) {
		int n,d;
		n = (numerator * other.numerator);
		d = (denominator * other.denominator);
		
		return new RationalNumber(n,d);
	}
	
	public RationalNumber divide(RationalNumber other) {
		int n,d;
		n = (numerator * other.denominator);
		d = (denominator * other.numerator);
		
		return new RationalNumber(n,d);
	}
	
	
}
