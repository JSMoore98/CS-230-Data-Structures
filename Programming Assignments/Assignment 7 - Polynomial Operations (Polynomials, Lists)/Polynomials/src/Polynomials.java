import java.io.*;
import java.util.Scanner;

/**
 * This program uses the list data structure to create and perform operations on
 * polynomials read from an input file
 * @author Josiah Moore
 */
public class Polynomials {

	public static void main(String[] args) throws FileNotFoundException {
		// Sets up the scanner and variables
		File text = new File("polynomials.txt");
		Scanner file = new Scanner(text);
		int eval, evalResult;
		String line = "";

		// Creates the lists
		ABList<Integer> polyP = new ABList<Integer>();
		ABList<Integer> polyQ = new ABList<Integer>();
		ABList<Integer> polyR = new ABList<Integer>();

		eval = Integer.parseInt(file.nextLine());

		// Initializes and displays the polynomials
		System.out.println(
				"The program is reading the input file to obtain the polynomials. " + "The two polynomials are: ");
		line = file.nextLine();
		createPoly(line, polyP);
		System.out.println("p(x) = " + showPoly(polyP));

		line = file.nextLine();
		createPoly(line, polyQ);
		System.out.println("q(x) = " + showPoly(polyQ));

		// Performs operations on the polynomials
		System.out.println("\nProgram is now performing arithmetic operations on the two polynomials...");
		add(polyP, polyQ, polyR);
		System.out.println(showPoly(polyP) + " + " + showPoly(polyQ) + " = " + showPoly(polyR));

		polyR.reset();

		subtract(polyP, polyQ, polyR);
		System.out.println(showPoly(polyP) + " - " + showPoly(polyQ) + " = " + showPoly(polyR));
		
		polyR.reset();

		multiply(polyP, polyQ, polyR);
		System.out.println(showPoly(polyP) + " * " + showPoly(polyQ) + " = " + showPoly(polyR));

		// Evaluates the polynomials
		System.out.println("\nThe program is now evaluating each polynomial using x = " + eval);
		evalResult = evaluate(eval, polyP);
		System.out.println("p(" + eval + ") = " + evalResult);
		evalResult = evaluate(eval, polyQ);
		System.out.println("q(" + eval + ") = " + evalResult);

		System.out.println("\nThe program has now finished.");

		file.close();

	}

	// Creates the polynomials
	public static void createPoly(String line, ABList<Integer> poly) {
		int i = 0;
		int co = 0;
		while (i < line.length() - 1) {
			i = co + 2;
			poly.insert((int) line.charAt(co) - 48, (int) line.charAt(i) - 48);
			co = i + 2;
		}
	}

	// Returns a string with the polynomials formatted for reading
	public static String showPoly(ABList<Integer> poly) {
		String str = "(" + poly.get(0);
		for (int i = 1; i < poly.size(); i++)
			if (poly.get(i) != 0)
				str = str + " + " + poly.get(i) + "x^" + i;
		str = str + ")";
		return str;
	}

	// Evaluates the given polynomial with the given value
	public static int evaluate(int eval, ABList<Integer> poly) {
		int sum = 0;
		for (int i = 0; i < poly.size(); i++)
			sum = sum + (poly.get(i) * (int) (Math.pow(eval, i)));
		return sum;
	}

	// Adds the two polynomials
	public static void add(ABList<Integer> polyP, ABList<Integer> polyQ, ABList<Integer> polyR) {
		int i = 0;
		while (i < polyP.size() && i < polyQ.size()) {
			polyR.insert(polyP.get(i) + polyQ.get(i), i);
			i++;
		}
		while (i < polyP.size()) {
			polyR.insert(polyP.get(i), i);
			i++;
		}
		while (i < polyQ.size()) {
			polyR.insert(polyQ.get(i), i);
			i++;
		}
	}

	// Subtracts the two polynomials
	public static void subtract(ABList<Integer> polyP, ABList<Integer> polyQ, ABList<Integer> polyR) {
		int i = 0;
		while (i < polyP.size() && i < polyQ.size()) {
			polyR.insert(polyP.get(i) - polyQ.get(i), i);
			i++;
		}
		while (i < polyP.size()) {
			polyR.insert(polyP.get(i), i);
			i++;
		}
		while (i < polyQ.size()) {
			polyR.insert(polyQ.get(i), i);
			i++;
		}
	}
	
	//Multiplies the two polynomials
	public static void multiply(ABList<Integer> polyP, ABList<Integer> polyQ, ABList<Integer> polyR) {
		for(int i = 0; i < polyQ.size(); i++)
			for(int j = 0; j < polyP.size(); j++) {
				int add = 0;
				int deg = i+j;
				if (polyR.size() > deg) {
					add= add + polyR.get(deg);
					polyR.remove(deg);
				}
				add = add + (polyQ.get(i) * polyP.get(j));
				polyR.insert(add, deg);
			}
	}
}