import java.util.Scanner;
/**
 * Checks if an expression has correctly matching parenthesis
 * Uses an Integer ABStack to specify which parenthesis match by index
 */
public class ParenthesisChecking {

	public static void main(String[] args) {
		String expression="";
		char ch;
		StackArray<Integer> stack = new StackArray<Integer>(20);
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter an expression: ");
		expression = keyboard.nextLine();
			
		for(int i = 0;i < expression.length(); i++) {
			ch = expression.charAt(i);
				
			if(ch == '(') {
				stack.push(i);
			}
			else if(ch == ')') {
				if(stack.isEmpty())
					System.out.println(") at index "+i+" does not have a matching (");
				else
					System.out.println(" ) at index "+i+" matches the ( at index "+stack.pop());
			}	
		
		}

		while(!stack.isEmpty())
			System.out.println("( at index "+stack.pop()+" does not have a matching )");

		keyboard.close();
	}

}
