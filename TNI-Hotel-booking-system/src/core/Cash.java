package core;

import java.text.DecimalFormat;

public class Cash {

	private double price;
	private Summary summary;

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	public Cash() {
		this.price = 5000;
	}

	public Cash(double price) {
		this.price = price;
	}

	public String getPrice() {
		return frm.format(price);
	}

	public boolean checkMoney(int money) {
		return (money >= price);
	}

	public String getChange(int money) {
		return frm.format((money - price));
	}

}
