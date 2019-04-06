import java.util.Random;
import java.text.DecimalFormat;

public class HourlyEmployeeDriver {

	public static void main(String[] args) {
		
		/*
		double salary;
		Random rand = new Random();
		int hours = rand.nextInt( 80);
		DecimalFormat formatter = new DecimalFormat( ",##0.00");
		
		Employee bob = new Employee( "Bob", "Smith", "000-00-0000");	
		System.out.println( bob);
		
		HourlyEmployee mary = new HourlyEmployee( "Mary", "Smith", "123-45-6789",5, 6);
		System.out.println( mary);
		
		hours = rand.nextInt( 80);
		mary.setHours( hours);
		mary.setRate( 35.0);
		System.out.println( mary);
		salary = mary.computeSalary();
		System.out.println( mary.getFirstName() + "'s salary is: $" + formatter.format( salary));
		*/
		
		Employee bob = new Employee("Bob", "Smith", "134-06-5627");
		HourlyEmployee mary = new HourlyEmployee("Mary","Smith","111-11-1111",40,40);
		HourlyEmployee jane = mary.copy();
		jane.setName("Jane", "Martin");
		
		System.out.println(bob);
		System.out.println(mary);
		System.out.println(jane);
		
		System.out.println( "\nDone.");
		
		return;
	}
}
