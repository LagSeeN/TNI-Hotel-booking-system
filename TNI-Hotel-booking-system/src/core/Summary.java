package core;

import java.text.DecimalFormat;

public class Summary {

	private double price;
	private String coupon;
	private double total;

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	
	public Summary() {
		this.price = 2000;
		this.coupon = "";
		this.total = 5000;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotal() {
		return total;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getPricetoString() {
		return frm.format(price);
	}
	
	public String getTotaltoString() {
		return frm.format(total);
	}

}
