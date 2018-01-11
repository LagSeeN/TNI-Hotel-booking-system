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

			// �Ѻ�Ţ�ѵ��ҡ��ѧ�ش��˹���ش �� 4115 1428 ������ 8 �ҤԴ��͹
			int digit = card[length - i - 1];

			// �Ţ��ѡ������令ٳ2
			if (i % 2 == 1) {
				digit *= 2;
			}
			// �ٵ����Ţ sum ����ҡ���� 9 ����ź 9
			// ������ҧ
			// 9*2 = 18 ��ҤԴ��ͤ�� �¡ 1 �Ѻ 9 �͡ ���� 1+9 = 10
			// �к�����ѹ������� ������ 9*2 = 18 �������� - 9 ���� 10 �ʹ�
			// ������ҧ������� �� 7*2 = 14 = 1+4 = 5 �к�����Դ 7*2 = 14 =
			// 14-9 = 5
			sum += digit > 9 ? digit - 9 : digit;
		}
		// ������ 10 ŧ���������繺ѵ���
		return sum % 10 == 0;
	}
}
