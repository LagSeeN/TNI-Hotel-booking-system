package core;

import java.util.ArrayList;
import java.util.List;

public class credit_card {

	public boolean checkName(String name) {
		int space_bar = 0;
		for (int i = 0; i < name.length(); i++)
			if (name.charAt(i) == ' ')
				space_bar++;
		return (space_bar > 1 || space_bar == 0 || name.startsWith(" ") || name.endsWith(" ")) ? false : true;
	}

	public boolean checkCard(String text_digits) {
		List<Integer> digits = new ArrayList<Integer>();
		for (int i = 0; i < text_digits.length(); i++) {
			char c = text_digits.charAt(i);
			digits.add(Integer.valueOf(c - '0'));
		}

		int[] card = new int[digits.size()];
		for (int i = 0; i < card.length; i++) {
			card[i] = Integer.valueOf(digits.get(i));
		}

		int sum = 0;
		int length = card.length;
		for (int i = 0; i < length; i++) {

			// รับเลขบัตนจากหลังสุดมาหน้าสุด เช่น 4115 1428 ก็จะเอา 8 มาคิดก่อน
			int digit = card[length - i - 1];

			// เลขหลักคู่เอาไปคูณ2
			if (i % 2 == 1) {
				digit *= 2;
			}
			// สูตรหาเลข sum ถ้ามากกว่า 9 เอาไปลบ 9
			// ตัวอย่าง
			// 9*2 = 18 ถ้าคิดมือคือ แยก 1 กับ 9 ออก จะเป็น 1+9 = 10
			// ระบบคอมมันทำไม่ได้ เลยเอา 9*2 = 18 แล้วเอาไป - 9 จะได้ 10 พอดี
			// ตัวอย่างอื่นๆก็มี เช่น 7*2 = 14 = 1+4 = 5 ระบบคอมคิด 7*2 = 14 =
			// 14-9 = 5
			sum += digit > 9 ? digit - 9 : digit;
		}
		// ถ้าหาร 10 ลงตัวแปลว่าเป็นบัตรแท้
		return sum % 10 == 0;
	}
}
