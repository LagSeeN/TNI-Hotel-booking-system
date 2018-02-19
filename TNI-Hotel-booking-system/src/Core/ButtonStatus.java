package Core;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ButtonStatus {
	private boolean[][] Click;
	
	public ButtonStatus() throws IOException {
		this.Click = new boolean [getX()] [getY()];
		StatusReset();
	}
	
	
	public void StatusReset() throws IOException {
		for (int i = 0; i < getX(); i++) {
			for (int j = 0; j < getY(); j++) {
				Click[i][j] = false;
			}
		}
	}
	
	public void setStatus(String Floor, String ShortRoomID) {
		if (Click[Integer.parseInt(Floor.substring(1))][Integer.parseInt(ShortRoomID)] != true) {
			Click[Integer.parseInt(Floor.substring(1))][Integer.parseInt(ShortRoomID)] = true;
		}
		else {
			Click[Integer.parseInt(Floor.substring(1))][Integer.parseInt(ShortRoomID)] = false;
		}
	}
	
	public boolean getStatus(String Floor, String ShortRoomID) {
		return Click[Integer.parseInt(Floor.substring(1))][Integer.parseInt(ShortRoomID)];
	}
	
	private int getX() throws IOException {
		int Floor = 0;
		while (new File("res//Database//Floor//F" + Floor + ".txt").exists()) {
			Floor++;
		}
		return Floor;
	}
	
	private int getY() throws IOException {
		int Room = 0;
		Scanner scan = new Scanner(new File("res//Database//Floor//F1.txt"));
		while (scan.hasNextLine()) {
			Room++;
		}
		scan.close();
		return Room;
	}

}
