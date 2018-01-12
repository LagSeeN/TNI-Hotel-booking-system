package core;

import java.text.DecimalFormat;

public class Cash {

	private Summary summary;

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	public Cash() {
		this.summary = new Summary();
	}

	public String getPricetoString() {
		return frm.format(summary.getTotal());
	}

	public boolean checkMoney(int money) {
		return (money >= (summary.getTotal()));
	}

	public String getChangetoString(int money) {
		return frm.format((money - summary.getTotal()));
	}

}
