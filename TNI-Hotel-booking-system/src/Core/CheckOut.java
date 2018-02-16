package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CheckOut extends RoomService {
	private List<String> roomCheckout = new ArrayList<String>();

	public void setRoomCheckOut(String room) {
		this.roomCheckout.add(room);
	}

	// ล้างตัวแปร array list
	public void removeRoomALL() {
		this.roomCheckout.removeAll(roomCheckout);
	}

	public void checkOutFile() {
		for (int i = 0; i < roomCheckout.size(); i++) {
			String[] data = roomCheckout.get(i).split(",");
			String filename = data[0];
			String room = data[1];
			super.readFile(filename);
			try {
				String message = "";
				for (int j = 0; j < super.getRoomID().length; j++) {
					if (super.getRoomID()[j].substring(1).equals(room))
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ "1\n";
					else
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ super.getStatus()[j] + "\n";
				}
				PrintWriter print = new PrintWriter(new FileWriter("res//Database//Floor//" + filename + ".txt"));
				print.print(message);
				print.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Check Out Fail!!!", "Fail Check Out", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Check Out Complete", "Check Out Complete",
				JOptionPane.INFORMATION_MESSAGE);

	}
}
