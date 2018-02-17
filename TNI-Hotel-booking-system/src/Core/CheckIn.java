package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CheckIn extends RoomService {
	private List<String> roomCheckin = new ArrayList<String>();

	public void setRoomCheckin(String room) {
		this.roomCheckin.add(room);
	}

	public void removeRoomAll() {
		this.roomCheckin.clear();
	}

	public void checkinFile() {
		for (int i = 0; i < roomCheckin.size(); i++) {
			String[] data = roomCheckin.get(i).split(",");
			String filename = data[0];
			String room = data[1];
			super.readFile(filename);
			try {
				String message = "";
				for (int j = 0; j < super.getRoomID().length; j++) {
					if (super.getRoomID()[j].substring(1).equals(room) && super.getStatus()[j] == 1)
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ "0\n";
					else
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ super.getStatus()[j] + "\n";
				}
				PrintWriter print = new PrintWriter(new FileWriter("res//Database//Floor//" + filename + ".txt"));
				print.print(message);
				print.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Checkin Error", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public double CalPrice() {
		double Price = 0.0;
		for (int i = 0; i < roomCheckin.size(); i++) {
			String[] data = roomCheckin.get(i).split(",");
			String filename = data[0];
			String room = data[1];
			super.readFile(filename);
			for (int j = 0; j < super.getRoomID().length; j++) {
				if (super.getRoomID()[j].substring(1).equals(room) && super.getStatus()[j] == 1)
					Price += super.getPrice()[j];
			}
		}
		return Price;
	}
	
	public int CalRoom() {
		return this.roomCheckin.size();
	}
	
	public boolean CheckinCheckList() {
		DecimalFormat fml = new DecimalFormat("#,###.00");
		if (!this.roomCheckin.isEmpty()) {
			int Select = JOptionPane.showConfirmDialog(null, "Room in list will set to check in : " + roomCheckin.toString() + "\nTotal Price : "+ fml.format(CalPrice()) + "\nPlease recheck before click \"Yes\"", "Confirm your Opeation", JOptionPane.YES_NO_OPTION);
			if (Select == 0) {
				return true;
			}
			else {
				removeRoomAll();
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "You didn't select any room, It's have no any effect.");
		}
		return false;
	}

}
