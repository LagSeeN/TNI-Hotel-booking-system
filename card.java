import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Card {

	public static boolean check(int[] digits) {
		int sum = 0;
		int length = digits.length;
		for (int i = 0; i < length; i++) {

			// รับเลขบัตนจากหลังสุดมาหน้าสุด เช่น 4115 1428  ก็จะเอา 8  มาคิดก่อน
			int digit = digits[length - i - 1];

			// เลขหลักคู่เอาไปคูณ2
			if (i % 2 == 1) {
				digit *= 2;
			}
			//สูตรหาเลข sum ถ้ามากกว่า 9 เอาไปลบ 9
			//ตัวอย่าง
			// 9*2 = 18 ถ้าคิดมือคือ แยก 1 กับ 9 ออก จะเป็น 1+9 = 10
			//ระบบคอมมันทำไม่ได้ เลยเอา 9*2 = 18 แล้วเอาไป - 9 จะได้ 10 พอดี
			//ตัวอย่างอื่นๆก็มี เช่น 7*2 = 14 = 1+4 = 5 ระบบคอมคิด 7*2 = 14 = 14-9 = 5
			sum += digit > 9 ? digit - 9 : digit;
		}
		//ถ้าหาร 10 ลงตัวแปลว่าเป็นบัตรแท้
		return sum % 10 == 0;
	}
	
	public static void main(String[] args) {
		boolean repeat;
		
		//ใช้ตัวแปร array list
		List<Integer> digits = new ArrayList<Integer>();

		do {
			repeat = false;
			String input = JOptionPane.showInputDialog("Enter your Credit Card Number : ");

			// code เช็ค ว่าเป็น ตัวเลขหรือไม่ ถ้าไม่รับใหม่
			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				if (c < '0' || c > '9') {
					repeat = true;
					digits.clear();
					break;
				} else {
					//ถ้าใช้ เอาเลจนั้นใส่ไปในตัวแปร array list
					digits.add(Integer.valueOf(c - '0'));
				}
			}
		} while (repeat);

		int[] array = new int[digits.size()];
		for (int i = 0; i < array.length; i++) {
			//แปลง เลขจาก char เป็น  int เพื่อนำไปคำนวณ
			array[i] = Integer.valueOf(digits.get(i));
		}
		boolean valid = check(array);
		//แสดงผล
		JOptionPane.showMessageDialog(null, "Valid: " + valid);
	}
}