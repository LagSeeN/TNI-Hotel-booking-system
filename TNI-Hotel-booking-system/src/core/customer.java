package core;

public class customer {
	private String name;
	private String ID;
	private String licenseplate;
	private String phone;
	
	public customer() {
		this.name = "";
		this.ID = "";
		this.licenseplate = "";
		this.phone = "";
	}
	
	public customer(String name, String ID, String licenseplate, String phone) {
		this.name = name;
		this.ID = ID;
		this.licenseplate = licenseplate;
		this.phone = phone;
	}

}
