import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The PreferredCustomer Driver Utilizes the Preferred Customer Class
 * @author Josiah Moore
 *
 */
public class PreferredCustomerDriver {
	
	/*TO DO LIST:
	 * ARE DEFAULT CONSTRUCTORS NECESSARY?
	 * CLEAR FRONT WHITESPACE?
	 * BETTER LOOKING OUTPUT?
	 */	
	
	public static void main (String[] args) throws FileNotFoundException {
		
		File file = new File("customer.txt");
		Scanner keyboard = new Scanner(file);
		
		ArrayList<PreferredCustomer> customers = new ArrayList<>();
		
		//Customer List Builder
		
		while(keyboard.hasNextLine()) {
			String line = keyboard.nextLine();
			
			String[] tokens = line.split(";");
			int size = tokens.length;
			
			if(size==6) {
				PreferredCustomer account = new PreferredCustomer(tokens[0],tokens[1],
								tokens[2],tokens[3],Boolean.parseBoolean(tokens[4].trim()),
								Double.parseDouble(tokens[5]));
			
				customers.add(account);
			}
		}
		
		//Output Commands
		
		System.out.println("Customer Name/Customer's Discount Level/Customer's Number:");
		System.out.println("==========================================================");
		
		for (PreferredCustomer account : customers) {
			System.out.println(account.getName() + " / " + account.getDiscount() +
					           "% / " + account.getId());
		}
		
		System.out.println();
		System.out.println("Mailing List:");
		System.out.println("=============");
		
		for (PreferredCustomer account : customers) {
			if (account.getOptIn())
				System.out.println(account.getName() + " / " + account.getAddress());
		}
		
		System.out.println();
		System.out.println("Phone List:");
		System.out.println("===========");
		
		for (PreferredCustomer account : customers) {
			if (account.getOptIn())
				System.out.println(account.getName() + " / " + account.getPhone());
		}
		
		System.out.println();
		System.out.println("Program has finished running.");	
		
		keyboard.close();
	}
}