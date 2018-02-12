package core;

import java.text.DecimalFormat;

public class Cash {

	private double price;

	public Cash(double price) {
		this.price = price;
	}

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	public String getPricetoString() {
		return frm.format(price);
	}

	public boolean checkMoney(double money) {
		return (money >= price);
	}

	public String getChangetoString(double money) {
		return frm.format((money - price));
	}
}
