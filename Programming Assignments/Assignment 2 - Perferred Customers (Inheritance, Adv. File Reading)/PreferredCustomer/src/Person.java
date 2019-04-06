/**
 * The Person Class
 * @author Josiah Moore
 *
 */
public class Person {
	private String name,address,phone;
	
	//Constructors
	
	public Person (String name, String address, String phone) {
		this.name = name;
		this.phone = phone;
		this.address = address;
	}
	
	public Person () {
		this.name = "John Smith";
		this.phone = "111-111-1111";
		this.address = "1111 House rd.";
	}
	
	public Person(Person other) {
		this.name = other.name;
		this.phone = other.phone;
		this.address = other.address;
	}
	
	//Access Methods
	
	public Person copy() {
		return new Person(name,address,phone);
	}
	
	public String toString() {
		String str;
		str = "Name: " + name + "\nAddress: " + address + "\nPhone Number: " + phone;
		return str;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
