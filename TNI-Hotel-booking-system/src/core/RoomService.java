package core;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

//import java.io.*;

public class RoomService {
	// private File file;
	private int RoomSize;
	private int Floor;
	private double RoomPrice;

	private String Status;
	private String ActionText;
	private Color btnBackground;
	private Boolean btnSetting;

	private String RoomID;
	private String BedType;

	public void setRoomsize(int RoomSize) {
		this.RoomSize = RoomSize;
	}

	public int getRoomsize() {
		return RoomSize;
	}
	
	private void setRoomPrice(double RoomPrice) {
		this.RoomPrice = RoomPrice;
	}

	public double getRoomPrice() {
		return RoomPrice;
	}

	public void setFloor(int Floor) {
		this.Floor = Floor;
	}

	public int getFloor() {
		return this.Floor;
	}

	private void setStatus(String Status) {
		this.Status = Status;
	}

	public String getStatus() {
		return this.Status;
	}

	private void setActionText(String ActionText) {
		this.ActionText = ActionText;
	}

	public String getActionText() {
		return this.ActionText;
	}

	private void setBtnBackground(Color btnBackground) {
		this.btnBackground = btnBackground;
	}

	public Color getBtuBackground() {
		return this.btnBackground;
	}

	private void setBtnSetting(boolean btnSetting) {
		this.btnSetting = btnSetting;
	}

	public boolean getBtnSetting() {
		return this.btnSetting;
	}

	private void setRoomID(String RoomID) {
		this.RoomID = RoomID;
	}

	public String getRoomID() {
		return this.RoomID;
	}

	private void setBedType(String BedType) {
		this.BedType = BedType;
	}

	public String getBedType() {
		return this.BedType;
	}

	public void ReadFile() {
		String[] RoomID = new String[getRoomsize()];
		String[] BedType = new String[getRoomsize()];
		double[] Price = new double[getRoomsize()];
		int[] Status = new int[getRoomsize()];
		try {
			BufferedReader br = new BufferedReader(new FileReader("res//Database//Floor//" + getFloor() + ".txt"));
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
					setStatus("Occupied");
					setActionText("Check Out");
					setBtnBackground(Color.RED);
					setBtnSetting(true);
					break;
				case 1:
					setStatus("Open");
					setActionText("Check In");
					setBtnBackground(Color.GREEN);
					setBtnSetting(true);
					break;
				case 2:
					setStatus("Maintenance");
					setActionText("Not available");
					setBtnBackground(Color.BLACK);
					setBtnSetting(false);
					break;
				}
				setRoomID(RoomID[i]);
				setBedType(BedType[i]);
				setRoomPrice(Price[i]);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}
}