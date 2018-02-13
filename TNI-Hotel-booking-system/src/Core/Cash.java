package Core;

import java.text.DecimalFormat;

public class Cash implements Interface.Cash {

	private double price;

	public Cash(double price) {
		this.price = price;
	}

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	@Override
	public String getPricetoString() {
		return frm.format(price);
	}

	@Override
	public boolean checkMoney(double money) {
		return (money >= price);
	}

	@Override
	public String getChangetoString(double money) {
		return frm.format((money - price));
	}
}
