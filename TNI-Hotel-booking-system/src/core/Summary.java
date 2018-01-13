package core;

import java.text.DecimalFormat;

public class Summary {

	private double price;
	private double total;
	private double discount;

	DecimalFormat frm = new DecimalFormat("#,##0.00");

	public Summary() {
		this.price = 0;
		this.total = 0;
	}

	public Summary(double price) {
		this.price = price;
		this.total = price;
	}

	public double getTotal() {
		return total - discount;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getPricetoString() {
		return frm.format(price);
	}

	public String getTotaltoString() {
		return frm.format(getTotal());
	}

	public String getDiscounttoString() {
		return "-" + frm.format(discount);
	}

	public boolean checkCoupon(String coupon) {
		String[] coupon_list = { "FREE", "FREE1R", "40SELL" };
		int[] coupon_discount = { (int) price, 700, (int) ((int) (price * 40 / 100)) };
		for (int i = 0; i < coupon_list.length; i++) {
			if (coupon.equalsIgnoreCase(coupon_list[i])) {
				discount = coupon_discount[i];
				return true;
			}

		}
		return false;
	}
}
