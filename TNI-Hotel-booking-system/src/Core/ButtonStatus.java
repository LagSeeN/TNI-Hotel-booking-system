package Core;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

public class ButtonStatus extends RoomService {

	public ButtonStatus() {

	}

	public void setButton(String fileroom, String RoomID) throws IOException {
		try {
			super.readBtnStatus(fileroom);
			PrintStream print = new PrintStream(new File("res//Database//Floor//boolean_" + fileroom + ".txt"));
			for (int i = 0; i < super.getBtnStatus().length; i++) {
				if (i == Integer.parseInt(RoomID.substring(1))) {
					if (super.getBtnStatus()[i] == true)
						print.println(false);
					else
						print.println(true);
				}
				else {
					print.println(super.getBtnStatus()[i]);
				}
			}

		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Button Status Error", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean getButton() {
		super.getBtnStatus();
		return true;
	}
}
