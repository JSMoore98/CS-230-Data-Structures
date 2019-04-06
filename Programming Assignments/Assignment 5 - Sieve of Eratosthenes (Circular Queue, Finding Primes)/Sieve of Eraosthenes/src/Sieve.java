import java.io.IOException;
import java.util.Scanner;

/**
 * This program uses the Sieve of Eratosthenes algorithm to find all primes up to a given number
 * @author Josiah Moore
 *
 */
public class Sieve {

	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		boolean again = true;
		String answer = null;
		boolean valid = false;
		int n = 0;
		int c = 0;

		while (again) {
			//Gets a valid input number
			do {
				System.out.println("Please enter a positive integer greater than 2: ");
				n = keyboard.nextInt();

				if (n >= 2)
					valid = true;
				else
					System.out.println("Invalid Number");

			} while (!valid);

			//Creates and fills the queue of numbers
			ABQueue<Integer> primes = new ABQueue<Integer>();
			CQueue<Integer> numbers = new CQueue<Integer>();

			for (int i = 2; i <= n; i++)
				numbers.enqueue(i);

			//Calls the method that gets all the prime
			getPrimes(primes, numbers, n);
			
			//Outputs the primes with ten to a line
			System.out.println("The primes are: \n");
			
			while (!primes.isEmpty()) {
				if (c == 10) {
					System.out.print("\n" + primes.dequeue() + " ");
					c = 1;
				}
				else {
					System.out.print(primes.dequeue() + " ");
					c++;
				}
			}
			
			//Checks is the user would like to repeat this process
			keyboard.nextLine();
			System.out.println("\nWould you like to continue? [Y/N]");
			answer = keyboard.nextLine();
			answer = answer.toLowerCase();
			if (answer.startsWith("y"))
				again = true;
			else
				again = false;
		}

		System.out.println("The program is finished running.");
		
		keyboard.close();
	}
	
/**
 * This method finds all of the primes in the list of numbers
 */
	public static void getPrimes(ABQueue<Integer> primes, CQueue<Integer> numbers, int n) {
		int prime = 0;
		int check = 0;
		int back = numbers.peekAtBack();

		while (prime != n) {
			prime = numbers.dequeue();
			primes.enqueue(prime);
			check = 0;
			//Checks if the prime number's multiples are still in the queue and need removed
			while (check != n && !numbers.isEmpty()) {
				back = numbers.peekAtBack();
				check = numbers.dequeue();
				
				if (check % prime != 0) {
					numbers.enqueue(check);
				}
				if (n % prime == 0)
					n = back;
			}
		}
		//Adds the remaining prime numbers to the prime queue
		while (!numbers.isEmpty())
			primes.enqueue(numbers.dequeue());
		return;
	}
}
