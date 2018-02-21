package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Maintenance extends RoomService implements Interface.RoomAction {
	private List<String> roomMaintenance = new ArrayList<String>();

	@Override
	public void setRoom(String room) {
		this.roomMaintenance.add(room);
	}

	// ล้างตัวแปร array list
	@Override
	public void removeRoomAll() {
		this.roomMaintenance.clear();
	}

	@Override
	public void writeFile() {
		for (int i = 0; i < roomMaintenance.size(); i++) {
			String[] data = roomMaintenance.get(i).split(",");
			String filename = data[0];
			String room = data[1];
			super.readFile(filename);
			try {
				String message = "";
				for (int j = 0; j < super.getRoomID().length; j++) {
					if (super.getRoomID()[j].substring(1).equals(room) && super.getStatus()[j] == 1)
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ "2\n";
					else if (super.getRoomID()[j].substring(1).equals(room) && super.getStatus()[j] == 2)
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
				JOptionPane.showMessageDialog(null, "Set to Maintanance fail!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Maintanance setting complete", "Maintanance",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void maintenanceCheckList() {
		if (!this.roomMaintenance.isEmpty()) {
			int Select = JOptionPane.showConfirmDialog(null,
					"Status of room in list will change : " + roomSelectList()
							+ "\nPlease recheck before click \"Yes\"",
					"Confirm your Opeation", JOptionPane.YES_NO_OPTION);
			if (Select == 0) {
				writeFile();
			}
		} else {
			JOptionPane.showMessageDialog(null, "You didn't select any room, It's have no any effect.", "Message",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public String roomSelectList() {
		String message = "[";
		for (String room : roomMaintenance)
			message += room.substring(1).replaceAll(",", "") + ",";
		message = message.substring(0, (message.length() - 1));
		message += "]";
		return message;
	}

	public void removeRoom(String room) {
		for (int i = 0; i < roomMaintenance.size(); i++)
			if (roomMaintenance.get(i).equals(room))
				roomMaintenance.remove(i);

	}

}
