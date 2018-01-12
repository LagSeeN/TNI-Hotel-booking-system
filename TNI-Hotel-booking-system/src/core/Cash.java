package core;

import java.text.DecimalFormat;

public class Cash {
	private double price;

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

	public boolean checkMoney(double money) {
		return (money >= price);
	}

	public String getChange(double money) {
		return frm.format((money - price));
	}

}
