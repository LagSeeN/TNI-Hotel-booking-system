package core;

import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Summary {

	private double price;
	private double total;
	private String discount;

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
		return total;
	}

	public String getPricetoString() {
		return frm.format(price);
	}

	public String getTotaltoString() {
		return frm.format(getTotal());
	}

	public String getDiscounttoString() {
		return discount;
	}

	public boolean checkCoupon(String coupon) throws IOException {
		CouponService CouponSys = new CouponService(coupon);
		if (coupon.isEmpty())
			return false;
		if (CouponSys.CouponReader().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Coupon invalid", "Coupon invalid", JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			String coupon_corret = CouponSys.CouponReader();
			String[] coupon_check = coupon_corret.split(";");
			total -= price * Integer.parseInt(coupon_check[1]) / 100;
			discount = coupon_check[2];
			return true;
		}
		// String[] coupon_list = { "FREE", "FREE1R", "40SELL" };
		// int[] coupon_discount = { (int) price, 700, (int) ((int) (price * 40
		// / 100)) };
		// for (int i = 0; i < coupon_list.length; i++) {
		// if (coupon.equalsIgnoreCase(coupon_list[i])) {
		// discount = coupon_discount[i];
		// return true;
		// }
		//
		// }
		// return false;
	}
}
