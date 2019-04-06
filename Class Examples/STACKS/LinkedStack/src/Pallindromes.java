import java.util.Scanner;
/**
 * Checks if a string is a palindrome using the Link Stack
 */
public class Pallindromes {

	public static void main(String[] args) {
		String str;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a word or expression string");
		str = keyboard.nextLine();
		if (isPalindrome(str))
			System.out.println(str + " is a palindrome");
		else
			System.out.println(str + " is not a palindrome");
		
		keyboard.close();
	}
	
	public static Boolean isPalindrome(String str) {
		
		LinkedStack<Character> stack = new LinkedStack<Character>();
		
		str = removeBlanks(str);
		str = str.toUpperCase();
		int length = str.length();
		
		for(int i=0; i < length; i++)
			stack.push(str.charAt(i));
		
		for(int i=0; i < length; i++)
			if (stack.pop() != str.charAt(i))
				return false;
		
		//Could be safe and check if the stack is empty, 
		//Not possible here because we prepared the stack code ourselves
		
		return true;
	}
	
	//Not the most efficient, uses length() and charAt() in each loop, you could avoid this
	public static String removeBlanks(String str) {
		
		String noBlanks = "";
		for(int i=0; i < str.length(); i++) {
			if(str.charAt(i) != ' ')
				noBlanks = noBlanks + str.charAt(i);
				
		}		
		return noBlanks;
	}

}
