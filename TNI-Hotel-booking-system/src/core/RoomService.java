package core;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RoomService {
	private int RoomSize;
	private String[] RoomID;
	private String[] BedType;
	private double[] Price;
	private int[] Status;
	public void ReadRoom(String floor) {
		RoomID = new String[RoomSize];
		BedType = new String[RoomSize];
		Price = new double[RoomSize];
		File file = new File(getClass().getClassLoader().getResource("Floor/" + floor + ".txt").getFile());
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			int i = 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				RoomID[i] = data[0];
				BedType[i] = data[1];
				Price[i] = Double.parseDouble(data[2]);
				Status[i] = Integer.parseInt(data[3]);
				i++;
			}
			br.close();
			for (i = 0; i < RoomSize; i++) {
				switch (Status[i]) {
				// if status 0 = Occupied, 1 = Open, 2 = M/A
				case 0:
					lblstatus_get_status[i].setText("Occupied");
					btn_action[i].setText("Check Out");
					btn_action[i].setBackground(Color.RED);
					btn_action[i].setEnabled(true);
					break;
				case 1:
					lblstatus_get_status[i].setText("Open");
					btn_action[i].setText("Check In");
					btn_action[i].setBackground(Color.GREEN);
					btn_action[i].setEnabled(true);
					break;
				case 2:
					lblstatus_get_status[i].setText("Maintenance");
					btn_action[i].setText("Not available");
					btn_action[i].setBackground(Color.BLACK);
					btn_action[i].setEnabled(false);
					break;
				}
				lblroomid_get_room[i].setText(RoomID[i]);
				lblbedtype_get_type[i].setText(BedType[i]);
				lblprice_get_price[i].setText(frm.format(Price[i]));
				OperationMode();
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}

	public void OperationMode() {
		if (rdbtnCheckIn.isSelected()) {
			btnContinue.setText("Pay");
			btnContinue.setBackground(Color.GREEN);
			rdbtnCheckIn.setVisible(true);
			rdbtnCheckOut.setVisible(true);
			lbloperationmode_text.setVisible(false);
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] != 1) {
					btn_action[i].setEnabled(false);
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Check In");
				}
			}
		}
		if (rdbtnCheckOut.isSelected()) {
			btnContinue.setText("Done");
			btnContinue.setBackground(Color.RED);
			rdbtnCheckIn.setVisible(true);
			rdbtnCheckOut.setVisible(true);
			lbloperationmode_text.setVisible(false);
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] != 0) {
					btn_action[i].setEnabled(false);
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Check Out");
				}
			}
		}
		if (rdbtnmntmMaintenance.isSelected()) {
			btnContinue.setText("Save");
			btnContinue.setBackground(Color.BLACK);
			rdbtnCheckIn.setVisible(false);
			rdbtnCheckOut.setVisible(false);
			lbloperationmode_text.setVisible(true);
			lbloperationmode_text.setText("Maintenance");
			for (int i = 0; i < RoomSize; i++) {
				if (Status[i] == 0) {
					btn_action[i].setEnabled(false);
				} else if (Status[i] == 1) {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Send to Maintenance");
				} else {
					btn_action[i].setEnabled(true);
					btn_action[i].setText("Send to Service");
				}
			}
		}
	}

	private void RoomService(String RoomID, double RoomPrice) {
		RoomList.add(RoomID);
		this.RoomPrice.add(RoomPrice);
		// JOptionPane.showMessageDialog(null, "DEMO:\nROOM ID : " + RoomID + "\nPRICE :
		// " + RoomPrice);
		TotalRoom++;
		lblTotalRoom_get.setText(String.valueOf(TotalRoom));
		TotalPrice += RoomPrice;
		lblTotalPrice_get.setText(frm.format(TotalPrice));
	}

}
