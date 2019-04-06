/**
 * Inheritance In-Class Example
 *
 */

public class Employee {

	protected String firstName;
	protected String lastName;
	protected String ssn;
	
	public Employee() {
	
		//You can use this to set all three strings, assignments keeps 
		//going to the write and resolves in reverse order
		firstName = lastName = ssn = "";
	}
	
	public Employee(String fname, String lname, String sn) {
		firstName = fname;
		lastName = lname;
		ssn = sn;
	}
	
	public Employee(Employee other) {
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.ssn = other.ssn;
	}
	
	public void setFirstName( String name) {
	
		this.firstName = name;
		return;
	}
	
	public void setLastName( String name) {

		this.lastName = name;
		return;
	}

	public void setName( String fname, String lname) {

		this.firstName = fname;
		this.lastName = lname;
		return;
	}
	
	public void setSSN( String ssn) {
	
		this.ssn = ssn;
		return;
	}
	
	public String getName() {
	
		return( this.firstName + " " + this.lastName);
	}
	
	public String getFirstName() {
	
		return( this.firstName);
	}
	
	public String getLastName() {
	
		return( this.lastName);
	}
	
	public String getSSN() {
		
		return this.ssn;
	}
	
	public String toString() {

		String str = "[";
		str = str + this.firstName + " ";
		str = str + this.lastName + ", " + this.ssn + "]";															 	// <<<<<<<<<<<<
		
		return( str);
	}
	
	//Equals is a useful method here
	public boolean equals( Employee e) {

		return( this.ssn.equals( e.ssn));	
	}

	public void copy( Employee e) {
	
		this.firstName = e.firstName;
		this.lastName = e.lastName;
		this.ssn = e.ssn;
		
		return;
	}
	
	public Employee copy() {
	
		Employee e = new Employee( this.firstName, this.lastName, this.ssn);
		
		return e;
	}
	
	//compareTo method as seen inside this method is built-in:
	//Returns -1 if first is smaller, 0 if equal, 1 if the first is larger
	public int compareTo( Employee e) {
		
		if(this.lastName.compareTo(e.lastName) < 0)
			return -1;
		else if(this.lastName.compareTo(e.lastName) == 0) {
			if(this.firstName.compareTo(e.firstName) < 0)
				return -1;
			if(this.firstName.compareTo(e.firstName) == 0)
				return 0;
			else
				return 1;
		}
		else
			return 1;
		}
		
		
}
