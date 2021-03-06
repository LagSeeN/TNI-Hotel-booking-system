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

	// ��ҧ����� array list
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
				PrintWriter print = new PrintWriter(new FileWriter("Database//Floor//" + filename + ".txt"));
				print.print(message);
				print.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Maintanance setting failed.", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Maintanance setting completed.", "Maintanance",
				JOptionPane.INFORMATION_MESSAGE);

	}

	public void maintenanceCheckList(String username) {
		if (!this.roomMaintenance.isEmpty()) {
			int Select = JOptionPane.showConfirmDialog(null, "Status of room in list will change : " + roomSelectList(),
					"Confirm your Opeation", JOptionPane.YES_NO_OPTION);
			if (Select == 0) {
				try {
					PrintLogs(username);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				writeFile();
			}
		}
	}

	@Override
	public String roomSelectList() {
		String message = "[";
		for (String room : roomMaintenance)
			message += room.substring(1).replaceAll(",", "") + ",";
		message = message.substring(0, (message.length() - 1));
		message += "]";
		return message;
	}

	@Override
	public void removeRoom(String room) {
		for (int i = 0; i < roomMaintenance.size(); i++)
			if (roomMaintenance.get(i).equals(room))
				roomMaintenance.remove(i);

	}

	public int CalRoom() {
		return this.roomMaintenance.size();
	}

	private void PrintLogs(String username) throws IOException {
		PrintWriter print = new PrintWriter(new FileWriter("Logs//RoomService//logs.txt", true));
		print.println(new TimeSystem().getDate() + " [Maintenance]   Rooms : " + roomSelectList()
				+ " has Set Maintenance/Send to Service by @" + username);
		print.close();
	}

}
//��͹�͡���� byTaitai
