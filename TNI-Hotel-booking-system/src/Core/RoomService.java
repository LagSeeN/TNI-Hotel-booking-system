package Core;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RoomService {

	private String[] RoomID = new String[6];
	private String[] BedType = new String[6];
	private double[] Price = new double[6];
	private int[] Status = new int[6];
	private boolean[] Click = new boolean[6];

	public void readFile(String floor) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res//Database//Floor//" + floor + ".txt"));
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}

	public void readBtnStatus(String floor) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res//Database//Floor//boolean_" + floor + ".txt"));
			int i = 0;
			while (Click[i] = br.readLine() != null) {
				i++;
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}
	}

	public String[] getRoomID() {
		return this.RoomID;
	}

	public String[] getBedType() {
		return this.BedType;
	}

	public double[] getPrice() {
		return this.Price;
	}

	public int[] getStatus() {
		return this.Status;
	}

	public boolean[] getBtnStatus() {
		return this.Click;
	}

	public String getStatusToString(int index) {
		if (Status[index] == 0)
			return "Occupied";
		if (Status[index] == 1)
			return "Open";
		return "Maintenance";
	}

	public String getButtonToString(int index) {
		if (Status[index] == 0)
			return "Check Out";
		if (Status[index] == 1)
			return "Check In";
		return "Not available";
	}

	public Color getColor(int index) {
		if (Status[index] == 0)
			return new Color(255, 0, 0);
		if (Status[index] == 1)
			return new Color(0, 255, 0);
		return new Color(0, 0, 0);

	}

	public boolean checkButton(int index) {
		return (Status[index] == 0 || Status[index] == 1) ? true : false;

	}

	public boolean[][] setDefault(boolean[][] roomcheck) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++)
				roomcheck[i][j] = false;
		}
		return roomcheck;
	}

}
