package core;

public class Customer {
	private String name;
	private String ID;
	private String licenseplate;
	private String phone;
	
	public Customer() {
		this.name = "";
		this.ID = "";
		this.licenseplate = "";
		this.phone = "";
	}
	
	public Customer(String name, String ID, String licenseplate, String phone) {
		this.name = name;
		this.ID = ID;
		this.licenseplate = licenseplate;
		this.phone = phone;
	}

}
