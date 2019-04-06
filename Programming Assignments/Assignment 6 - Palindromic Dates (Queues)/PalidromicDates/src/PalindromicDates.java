import java.io.IOException;
import java.util.Scanner;

/**
 * This program uses a link queue to see if a given year contains any palindromic dates
 * @author Josiah Moore
 *
 */

public class PalindromicDates {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		boolean again = true;
		String answer = null;
		boolean valid = false;
		int n = 0;

		while (again) {
			valid = false;
			// Gets a valid input number
			do {
				System.out.println("Please enter a four digit date: ");
				n = keyboard.nextInt();

				if (n >= 1000 && n <= 9999)
					valid = true;
				else
					System.out.println("Invalid Date");

			} while (!valid);

			String year = Integer.toString(n);
			System.out.println("Palindromic dates for the year " + year + ":");
			System.out.println(getDates(year));

			// Checks if the user would like to repeat this process
			keyboard.nextLine();
			System.out.println("\nWould you like to continue? [Y/N]");
			answer = keyboard.nextLine();
			answer = answer.toLowerCase();
			if (answer.startsWith("y"))
				again = true;
			else
				again = false;
		}

		/**
		 * Bonus Credit Modification
		 */

		LQueue<Integer> queue = new LQueue<Integer>();

		for (int i = 2000; i <= 2099; i++) {
			queue.enqueue(i);
		}

		again = true;

		while (!queue.isEmpty() && again) {
			String year = Integer.toString(queue.dequeue());
			if (!(getDates(year).startsWith("N"))) {
				System.out.println("The first palindromic date in the 21st century is: " + getDates(year));
				again = false;
			}
		}

		System.out.println("The program is finished running.");

		keyboard.close();

	}

	/**
	 * Checks if the year contains any palindromic dates
	 */
	public static String getDates(String year) {
		String month = year.substring(3) + year.substring(2, 3);
		int numMonth = Integer.parseInt(month);
		String day = year.substring(1, 2) + year.substring(0, 1);
		int numDay = Integer.parseInt(day);
		String reverse = month + day;
		String palindrome = "";
		int leapYear;

		if (numMonth == 4 || numMonth == 6 || numMonth == 9 || numMonth == 11) {
			if (numDay >= 1 && numDay <= 30) {
				palindrome = reverse + year;
			} else
				palindrome = "No palindrome exists for this year";
			return palindrome;
			
		} else if (numMonth == 2) {
			if (numMonth % 4 == 0)
				leapYear = 29;
			else
				leapYear = 28;
			if (numDay >= 1 && numDay <= leapYear) {
				palindrome = reverse + year;
			} else
				palindrome = "No palindrome exists for this year";
			return palindrome;
			
		} else if (numMonth >= 1 && numMonth <= 12) {
			if (numDay >= 1 && numDay <= 31) {
				palindrome = reverse + year;
			} else
				palindrome = "No palindrome exists for this year";
			return palindrome;
		}
		palindrome = "No palindrome exists for this year";
		return palindrome;
	}
}
