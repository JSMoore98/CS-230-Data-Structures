import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This program is an automated address book. It contains both an address object class and a driver for the
 * address book that utilizes the address objects
 * @author Josiah Moore
 */

/**
 * The Address object that stores all address information
 */
class Address implements Comparable<Address>{
	private String name, street, cityState, zip, country, phone, lName;
	public Address(String name, String street, String cityState, String zip, String country, String phone) {
		this.name = name;
		this.street = street;
		this.cityState = cityState;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		extractLastName();
	}
	
	public String toString() {
		String str = "";
		str += "Name: " + name + "\n";
		str += "Street: " + street + "\n";
		str += "City/State: " + cityState + "\n";
		str += "Zip Code: " + zip + "\n";
		str += "Country: " + country + "\n";
		str += "Phone Number: " + phone +"\n\n";
		return str;
	}
	
	public Address copy () {
		Address newAddress = new Address(name,street,cityState,zip,country,phone);
		return newAddress;
	}
	public static Address copy (Address other) {
		Address newAddress = new Address(other.name,other.street,other.cityState,other.zip,other.country,other.phone);
		return newAddress;
	}
	
	public void setAll(String name, String street, String cityState, String zip, String country, String phone) {
		this.name = name;
		this.street = street;
		this.cityState = cityState;
		this.zip = zip;
		this.country = country;
		this.phone = phone;
		extractLastName();
	}
	
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lName;
	}
	//Gets the last name field from the name
	public void extractLastName() {
		String tokens[];
		tokens = name.split(" ");
		lName = tokens[tokens.length-1];
	}
	public void setName(String name) {
		this.name = name;
		extractLastName();
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setStreet(int street) {
		this.street = Integer.toString(street);
	}
	public String getCityState() {
		return cityState;
	}
	public void setCityState(String cityState) {
		this.cityState = cityState;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public void setZip(int zip) {
		this.zip = Integer.toString(zip);
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setPhone(int phone) {
		this.phone = Integer.toString(phone);
	}	
	
	//Compares the two last names of an address record
	public int compareTo(Address other) {
		String name1 = lName.toLowerCase();
		String name2 = other.lName.toLowerCase();
		int compare = name1.compareTo(name2);
		if (compare > 0)
			return 1;
		if (compare < 0)
			return -1;
		return 0;
	}
}

/**
 * The driver class that implements the address book
 */
public class AddressBook {

	public static void main(String args[]) throws FileNotFoundException {
		String name, street, cityState, zip, country, phone, line;
		int choice = 0;
		name = street = cityState = zip = country = phone = line = "";
		File txt = new File("addresses.txt");
		Scanner file = new Scanner(txt);
		Scanner keyboard = new Scanner(System.in);
		LList<Address> book = new LList<Address>();
		boolean exit = false;

		//Reads in the records from the file
		while(file.hasNext()) {
			name = file.nextLine();
			street = file.nextLine();
			line = file.nextLine();
			String[] tokens = line.split(" ");
			cityState = tokens[0];
			cityState += " " + tokens[1];
			zip = tokens[2];
			country = file.nextLine();
			phone = file.nextLine();
			if(file.hasNext())
				file.nextLine();		
			
			Address entry = new Address(name, street, cityState, zip, country, phone);
			book.insertAtBack(entry);
		}
		
		System.out.println("The address book has been successfully loaded from the file.\n");
		
		//Displays the menu for as long as the user wants
		while(!exit) {
			Address searched = null;
			displayMenu();
			try {
				choice = keyboard.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Error, input was not an integer.");
			}
			keyboard.nextLine();
			//Calls the chosen menu method
			switch(choice) {
			case 1:
				searched = addRecord(keyboard, book);
				book.insertAtBack(searched);
				break;
			case 2:
				searched = findRecord(keyboard, book);
				if(searched != null)
					System.out.println(searched);
					book.insertAtBack(searched);
				break;
			case 3:
				searched = findRecord(keyboard, book);
				if(searched != null) {
					System.out.println("The record has been removed from the address book");
					System.out.println(searched);
				}
				break;
			case 4:
				searched = findRecord(keyboard, book);
				if(searched != null) {
					System.out.println("The original record is:");
					System.out.println(searched);
					searched = addRecord(keyboard, book);
					System.out.println("The address entry has been replaced with the modified version");
					book.insertAtBack(searched);
				}
				break;
			case 5:
				outputFile(book);
				break;
			case 6:
				searchZip(keyboard,book);
				break;
			case 7:
				System.out.println("Displaying every address record:");
				System.out.println("----------------------------");
				displayBook(book);
				System.out.println("----------------------------");
				break;
			case 8:
				exit = true;
				break;
			default:
				System.out.println("Please enter an integer that matches one of the choices listed.");
			}
			choice = 0;
		}

		keyboard.close();
		file.close();
	}
	
	public static void displayMenu() {
		System.out.println("----------------------------");
		System.out.println("1. Add a new address record");
		System.out.println("2. View an existing address record");
		System.out.println("3. Delete an existing address record");
		System.out.println("4. Modify an address record");
		System.out.println("5. Save the entire address book in a file");
		System.out.println("6. Retrieve all address entries using zip code");
		System.out.println("7. Print the entire address book on the screen");
		System.out.println("8. Exit the application");
		System.out.println("----------------------------");
	}
	
	//Creates a new address record and returns it
	public static Address addRecord(Scanner keyboard, LList<Address> book) {
		String name, street, cityState, zip, country, phone;
		name = street = cityState = zip = country = phone = "";
		
		System.out.println("Please enter the address owner's name:");
		name = keyboard.nextLine();
		System.out.println("Please enter the street address");
		street = keyboard.nextLine();
		System.out.println("Please enter the city and state in the form (city, state)");
		cityState = keyboard.nextLine();
		System.out.println("Please enter the zip code");
		zip = keyboard.nextLine();
		System.out.println("Please enter the country of the address");
		country = keyboard.nextLine();
		System.out.println("Please enter the address owner's phone number");
		phone = keyboard.nextLine();
		
		Address entry = new Address(name, street, cityState, zip, country, phone);		
		return entry;
	}
	
	//Finds an existing address record based on last name and returns it
	public static Address findRecord(Scanner keyboard, LList<Address> book) {
		String name = "";
		String lName ="";
		int i = 0;
		int size = book.size();
		Address current = null;
		System.out.println("Please enter the last name of the address record you wish to search for:");
		name = keyboard.nextLine();
		name = name.toLowerCase();
		name = name.trim();
		
		while(i<size) {
			current = book.removeFromFront();
			lName = current.getLastName();
			lName = lName.toLowerCase();
			lName = lName.trim();
			if (lName.compareTo(name)==0) {
				System.out.println("A matching record has been found.");
				return current;
			}
			book.insertAtBack(current);
			i++;
		}
		System.out.println("The name does not match any address records in the book");
		return null;
	}
	
	//Searches all addresses and output the ones that match the given zip code
	public static void searchZip(Scanner keyboard, LList<Address> book) {
		int zip = 0;
		int i = 0;
		int size = book.size();
		boolean valid = false;
		Address current;
		LList<Address> zips = new LList<Address>();
		
		System.out.println("Please enter the zip code you would like to search for");
		while (!valid) {
			try {
				zip = keyboard.nextInt();
				valid = true;
				keyboard.nextLine();
			}
			catch(InputMismatchException e) {
				System.out.println("Please enter a valid integer");
				keyboard.nextLine();
			}
		}
		
		while(i<size) {
			current = book.removeFromFront();
			try {
				if (Integer.parseInt(current.getZip()) == zip)
					zips.insertAtBack(current);
			}
			catch(NumberFormatException e) {
			}
			i++;
			book.insertAtBack(current);
		}
		
		System.out.println("Here are all records with the zip code " + zip + ":");
		displayBook(zips);
	}
	
	//Displays the entire address book
	public static void displayBook(LList<Address> book) {
		int i = 0;
		int size = book.size();
		Address current;
		
		while(i<size) {
			current = book.removeFromFront();
			System.out.print(current);
			book.insertAtBack(current);
			i++;
		}
	}
	
	//Outputs the book to a file
	public static void outputFile(LList<Address> book) throws FileNotFoundException {
		PrintWriter output = new PrintWriter("addressOutput.txt");
		int i = 0;
		int size = book.size();
		Address current;
		
		while(i<size) {
			current = book.removeFromFront();
			output.println("Name: " + current.getName());
			output.println("Street: " + current.getStreet());
			output.println("City/State: " + current.getCityState());
			output.println("Zip Code: " + current.getZip());
			output.println("Country: " + current.getCountry());
			output.println("Phone Number: " + current.getPhone());
			output.println();
			book.insertAtBack(current);
			i++;
		}
		
		System.out.println("The contents of the address book have been written to the file (addressOutput.txt)");
		output.close();
	}
}