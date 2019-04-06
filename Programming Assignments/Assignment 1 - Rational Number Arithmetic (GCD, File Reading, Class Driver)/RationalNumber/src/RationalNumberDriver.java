import java.io.*;
import java.util.Scanner;

/**
 * Driver for the RaionalNumber class
 * @author Josiah Moore
 */
public class RationalNumberDriver {

	public static void main(String[] args) throws IOException {
		
		//Declaring Variables
		File file = new File("fractions.txt");
		Scanner keyboard = new Scanner(file);
		int num1=0, num2=0, found=0;
		RationalNumber rational1 = new RationalNumber();
		RationalNumber rational2 = new RationalNumber();
		RationalNumber calc = new RationalNumber();

		//Getting two rational numbers
		System.out.println("Program is reading input file to "
				+ "validate two rational numbers...");
		while (keyboard.hasNext() && found < 2) {
			num1 = keyboard.nextInt();
			num2 = keyboard. nextInt();
			if (num2 != 0 && found == 0) {
				rational1 = new RationalNumber(num1,num2);
				System.out.println("The first valid fraction obtained is: "
									+ rational1.toString() + " " + rational1.toDecimal());
				found ++;
			}
			else if (num2 != 0 && found == 1) {
				rational2 = new RationalNumber(num1,num2);
				System.out.println("The second valid fraction obtained is: "
						+ rational2.toString() + " " + rational2.toDecimal());
				found ++;
			}
			else
				System.out.println("Invalid Fraction: denominator cannot be zero.");
		}
		
		//Performing operations on rational numbers
		System.out.println();
		System.out.println("Program is now performing arithmetic operations "
				+ "on the two fractions...");
		
		calc = new RationalNumber(rational1.add(rational2));
		System.out.println(rational1.toString() + " + " + rational2.toString() + 
						   " = " + calc.toString() + " = " + calc.toDecimal());
		
		calc = rational1.subtract(rational2);
		System.out.println(rational1.toString() + " - " + rational2.toString() + 
						   " = " + calc.toString() + " = " + calc.toDecimal());
		
		calc = rational1.multiply(rational2);
		System.out.println(rational1.toString() + " * " + rational2.toString() + 
						   " = " + calc.toString() + " = " + calc.toDecimal());
		
		if (rational2.toDecimal() == 0) {
			System.out.println("Invalid operation: Cannot divide if the second "
					+ "fraction is zero.");
		}
		else {
			calc = rational1.divide(rational2);
			System.out.println(rational1.toString() + " / " + rational2.toString() + 
						   	" = " + calc.toString() + " = " + calc.toDecimal()); }
		
		//BONUS: Comparing rational numbers
		System.out.println();
		System.out.println("Program is now comparing the two fractions...");
		
		if (rational1.toDecimal() > rational2.toDecimal())
			System.out.println(rational1.toString() + " is larger than " + rational2.toString());
		else if (rational1.toDecimal() < rational2.toDecimal())
			System.out.println(rational1.toString() + " is smaller than " + rational2.toString());
		else
			System.out.println(rational1.toString() + " is equal to " + rational2.toString());
		
		keyboard.close();
	}

}
