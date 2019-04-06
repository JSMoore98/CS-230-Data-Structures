/**
 * The Customer Class extends Person
 * @author Josiah Moore
 *
 */
public class Customer extends Person{
	
	private String id;
	private Boolean optIn;
	
	//Constructors
	
	public Customer(String name, String address, String phone, 
					String id, Boolean optIn) 
	{
		super(name,address,phone);
		this.id = id;
		this.optIn = optIn;
	}
	
	public Customer() {
		super();
		this.id = "1234";
		this.optIn = true;
	}
	
	public Customer(Customer other) {
		super(other);
		this.id = other.id;
		this.optIn = other.optIn;
	}
	
	//Access Methods
	
	public Customer copy() {
		return new Customer(getName(),getAddress(),getPhone(),id,optIn);
	}
	
	public String getId() {
		return id;
	}
	
	public Boolean getOptIn() {
		return optIn;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setOptIn(Boolean optIn) {
		this.optIn = optIn;
	}
	
	public String toString() {
		String str;
		str = super.toString();
		str = str.concat("\nCustomer ID: " + id + "\nMailing List Opt-In: " + optIn);
		return str;
	}
	
}
