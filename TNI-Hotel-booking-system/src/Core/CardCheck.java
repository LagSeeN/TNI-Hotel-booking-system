package Core;

import javax.swing.JOptionPane;

public class CardCheck implements Interface.CardCheck {
	private int[] card = new int[16];
	private String cardnumber;
	private String name;

	public CardCheck() {
		this.cardnumber = "";
		this.name = "";
	}

	public CardCheck(String name, String card) {
		this.cardnumber = card;
		this.name = name;
	}

	public CardCheck(String card) {
		this.cardnumber = card;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean checkCard() {
		if (cardnumber.startsWith("4") || cardnumber.startsWith("51") || cardnumber.startsWith("52")
				|| cardnumber.startsWith("53") || cardnumber.startsWith("54") || cardnumber.startsWith("55")) {
			for (int i = 0; i < this.card.length; i++) {
				this.card[i] = Integer.valueOf(this.cardnumber.charAt(i) - '0');
			}
			int sum = 0;
			int length = this.card.length;
			for (int i = 0; i < length; i++) {
				int digit = this.card[length - i - 1];
				if (i % 2 == 1) {
					digit *= 2;
				}
				sum += digit > 9 ? digit - 9 : digit;
			}
			return sum % 10 == 0;
		}
		return false;
	}

	@Override
	public boolean checkName() {
		int space_bar = 0;
		for (int i = 0; i < name.length(); i++)
			if (name.charAt(i) == ' ')
				space_bar++;
		if (!(space_bar > 2 || space_bar == 0 || name.startsWith(" ") || name.endsWith(" ")))
			return true;
		if (name.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please enter customer name.", "Request Name",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		JOptionPane.showMessageDialog(null, "Name is incorrect format"
				+ "\nPlease input customer name like \"fristname(space)lastname or fristname(space)midname(space)lastname\" and try again.",
				"Warning", JOptionPane.WARNING_MESSAGE);
		return false;

	}

}
