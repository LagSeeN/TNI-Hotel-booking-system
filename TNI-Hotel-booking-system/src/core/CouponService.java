package core;

import java.io.*;

public class CouponService {
	private String Coupon;

	public CouponService(String Coupon) {
		this.Coupon = Coupon;
	}

	public String CouponReader() throws IOException {
		BufferedReader CouponReader = new BufferedReader(
				new FileReader(new File(getClass().getClassLoader().getResource("coupon_database.txt").getFile())));
		String temp = "";
		while ((temp = CouponReader.readLine()) != null) {
			String[] data = temp.split(";");
			if (data[0].equalsIgnoreCase(Coupon)) {
				CouponReader.close();
				return temp;
			}
		}
		CouponReader.close();
		return "";
	}
}
