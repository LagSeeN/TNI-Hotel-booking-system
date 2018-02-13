package core;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class RoomServicebyDanupol {

	private String[] RoomID = new String[6];
	private String[] BedType = new String[6];
	private double[] Price = new double[6];
	private int[] Status = new int[6];

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
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

}
