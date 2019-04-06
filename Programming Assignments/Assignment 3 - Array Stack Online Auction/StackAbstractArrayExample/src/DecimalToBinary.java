import java.util.Scanner;
/**
 * Uses the stack to convert Decimal to Binary numbers
 * Gets a non-negative integer to convert
 * Uses the division-remainder method by putting the remainders on the stack
 * 
 * @author jmoore44
 *
 */
public class DecimalToBinary {

	public static void main(String[] args) {
		int number, divided;
		
		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("Enter a positive integer: ");
			number = keyboard.nextInt();
		} while (number < 0);
		divided = number;
		
		//Used to specify generic data type
		StackArray<Integer> stack = new StackArray<Integer>();
		
		while(divided != 0) {
			stack.push(divided % 2);
			divided = divided/2;
		}
		
		String convert = "";
		while(!stack.isEmpty())
			convert = convert + stack.pop();
		
		System.out.println(number + " in binary is: " + convert);
		
		keyboard.close();

	}

}
