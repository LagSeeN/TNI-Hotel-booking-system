package core;

public class credit_card {

	public boolean checkName(String name) {
		int space_bar = 0;
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ')
				space_bar++;
		}
		return (space_bar > 1 || space_bar == 0 || name.startsWith(" ") || name.endsWith(" ")) ? false : true;
	}

}
