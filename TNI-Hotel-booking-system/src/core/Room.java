package core;

public class Room {
	private String ID;
	private String bedtype;
	private double price;
	private boolean status;

	public Room() {
		this.ID = "";
		this.bedtype = "";
		this.price = 0.0;
		this.status = false;
	}

	public Room(String ID, String bedtype, double price, boolean status) {
		this.ID = ID;
		this.bedtype = bedtype;
		this.price = price;
		this.status = status;
	}
	
	public String getID() {
		return this.ID;
	}
	
	public String getBedtype() {
		return this.bedtype;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public boolean getStatus() {
		return this.status;
	}

}
