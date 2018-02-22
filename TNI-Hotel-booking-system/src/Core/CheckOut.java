package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class CheckOut extends RoomService implements Interface.RoomAction {
	private List<String> roomCheckout = new ArrayList<String>();
	private String username;

	@Override
	public void setRoom(String room) {
		this.roomCheckout.add(room);
	}

	// ล้างตัวแปร array list
	@Override
	public void removeRoomAll() {
		this.roomCheckout.removeAll(roomCheckout);
	}

	@Override
	public void writeFile() {
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
				JOptionPane.showMessageDialog(null, "Failed to Check Out.", "Message", JOptionPane.ERROR_MESSAGE);
			}
		}
		try {
			PrintLogs(this.username);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
		}
		JOptionPane.showMessageDialog(null, "Check Out complete", "Message", JOptionPane.INFORMATION_MESSAGE);

	}

	public void removeRoom(String room) {
		for (int i = 0; i < roomCheckout.size(); i++)
			if (roomCheckout.get(i).equals(room))
				roomCheckout.remove(i);

	}

	public int CalRoom() {
		return this.roomCheckout.size();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String roomSelectList() {
		String message = "[";
		for (String room : roomCheckout)
			message += room.substring(1).replaceAll(",", "") + ",";
		message = message.substring(0, (message.length() - 1));
		message += "]";
		return message;
	}

	public void PrintLogs(String username) throws IOException {
		PrintWriter print = new PrintWriter(new FileWriter("res//Logs//RoomService//logs.txt", true));
		print.println(new TimeSystem().getDate() + " [CheckOut]      Rooms : " + roomSelectList()
				+ " has Checked Out by @" + username);
		print.close();

	}
}
