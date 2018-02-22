package Core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class CheckIn extends RoomService implements Interface.RoomAction {
	private List<String> roomCheckin = new ArrayList<String>();

	@Override
	public void setRoom(String room) {
		this.roomCheckin.add(room);
	}

	@Override
	public void removeRoomAll() {
		this.roomCheckin.clear();
	}

	@Override
	public void writeFile() throws IOException {
		BufferedReader tempReader = new BufferedReader(new FileReader("Database//temp//CheckIn.txt"));
		String temp = "";
		while ((temp = tempReader.readLine()) != null) {
			try {
				String[] data = temp.split(",");
				String filename = data[0];
				String RoomID = data[1];
				super.readFile(filename);
				String message = "";
				for (int j = 0; j < super.getRoomID().length; j++) {
					if (super.getRoomID()[j].substring(1).equals(RoomID) && super.getStatus()[j] == 1)
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ "0\n";
					else
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ super.getStatus()[j] + "\n";
				}
				PrintWriter print = new PrintWriter(new FileWriter("Database//Floor//" + filename + ".txt"));
				print.print(message);
				print.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Checkin Error", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		tempReader.close();
	}

	public double CalPrice(int day) {
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
		return Price * day;
	}

	public int CalRoom() {
		return this.roomCheckin.size();
	}

	public boolean CheckinCheckList(int day) {
		DecimalFormat fml = new DecimalFormat("#,###.00");
		if (!this.roomCheckin.isEmpty()) {
			int Select = JOptionPane.showConfirmDialog(null,
					"Room in list will set to check in : " + roomSelectList() + "\nTotal Price : "
							+ fml.format(CalPrice(day)) + "\nPlease recheck before click \"Yes\"",
					"Confirm your Opeation", JOptionPane.YES_NO_OPTION);
			if (Select == 0) {
				return true;
			} else {
				removeRoomAll();
			}
		} else {
			JOptionPane.showMessageDialog(null, "You didn't select any room.", "Message", JOptionPane.WARNING_MESSAGE);
		}
		return false;
	}

	public void CheckinWrtter() throws IOException {
		PrintWriter temp = new PrintWriter(new FileWriter("Database//temp//CheckIn.txt"));
		for (int i = 0; i < roomCheckin.size(); i++) {
			temp.println(roomCheckin.get(i));
		}
		temp.close();
	}

	public String roomSelectList() {
		String message = "[";
		for (String room : roomCheckin)
			message += room.substring(1).replaceAll(",", "") + ",";
		message = message.substring(0, (message.length() - 1));
		message += "]";
		return message;
	}

	public void removeRoom(String room) {
		for (int i = 0; i < roomCheckin.size(); i++)
			if (roomCheckin.get(i).equals(room))
				roomCheckin.remove(i);

	}

	public void PrintLogs(String username, int day, String name) throws IOException {
		BufferedReader tempReader = new BufferedReader(new FileReader("Database//temp//CheckIn.txt"));
		String temp = "", RoomList = "[";
		while ((temp = tempReader.readLine()) != null) {
			RoomList += temp.substring(1).replaceAll(",", "") + ",";
		}
		RoomList = RoomList.substring(0, RoomList.length() - 1);
		RoomList += "]";
		tempReader.close();
		PrintWriter print = new PrintWriter(new FileWriter("Logs//RoomService//logs.txt", true));
		print.println(new TimeSystem().getDate() + " [CheckIn]       Rooms : " + RoomList + " has Checked in by @"
				+ username + " for " + day + " Day(s)" + " Booking by #" + name);
		print.close();
	}

}
