/**
 * The PreferredCustomer Class extends Customer
 * @author Josiah Moore
 *
 */
public class PreferredCustomer extends Customer{
	
	private int discount;
	private double purchases;
	
	//Constructors
	
	public PreferredCustomer (String name, String address, String phone, 
							  String id, Boolean optIn, double purchases)
	{
		super(name,address,phone,id,optIn);
		this.purchases = purchases;
		calcDiscount();
	}
	
	public PreferredCustomer() {
		super();
		this.purchases = 0;
		calcDiscount();
	}
	
	public PreferredCustomer (PreferredCustomer other) {
		super(other);
		this.purchases = other.purchases;
		calcDiscount();
	}
	
	//Access Methods
	
	public PreferredCustomer copy() {
		return new PreferredCustomer(getName(),getAddress(),
				   getPhone(),getId(),getOptIn(),purchases);
	}
	
	public double getPurchases() {
		return purchases;
	}
	
	public int getDiscount() {
		calcDiscount();
		return discount;
	}
	
	public void setPurchases(double purchases) {
		this.purchases = purchases;
		calcDiscount();
	}
	
	public String toString() {
		String str;
		str = super.toString();
		str = str.concat("\nCustomer Purchases: " + purchases + 
						 "\nDiscount Level: " + discount);
		return str;
	}
	
	//Updates the discount level based on the purchase amount
	public void calcDiscount() {
		if (purchases >= 2000)
			discount = 10;
		else if (purchases >= 1500)
			discount = 7;
		else if (purchases >= 1000)
			discount = 6;
		else if (purchases >= 500)
			discount = 5;
		else
			discount = 0;
	}
}
