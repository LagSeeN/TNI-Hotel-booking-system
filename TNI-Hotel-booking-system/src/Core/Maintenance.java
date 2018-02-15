package Core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Maintenance extends RoomService {
	private List<String> roomMaintenance = new ArrayList<String>();
	
	
	public void setRoomMaintenance(String room) {
		this.roomMaintenance.add(room);
	}

	
	public void removeRoomALL() {
		this.roomMaintenance.clear();
	}
	
	public void maintenanceFile() {
		for (int i = 0; i < roomMaintenance.size(); i++) {
			String[] data = roomMaintenance.get(i).split(",");
			super.readFile(data[0]);
			try {
				String message = "";
				for (int j = 0; j < super.getRoomID().length; j++) {
					if (super.getRoomID()[j].substring(1).equalsIgnoreCase(data[1]))
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ "2\n";
					else
						message += super.getRoomID()[j] + ";" + super.getBedType()[j] + ";" + super.getPrice()[j] + ";"
								+ super.getStatus()[j] + "\n";
				}
				PrintWriter print = new PrintWriter(new FileWriter("res//Database//Floor//" + data[0] + ".txt"));
				print.print(message);
				print.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Set to Maintanance fail!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		JOptionPane.showMessageDialog(null, "Set to Maintanance Complete", "Maintanance", JOptionPane.INFORMATION_MESSAGE);

	}

}
