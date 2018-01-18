package core;

import java.io.*;

public class LoginManager {
	private String username;
	private String password;
	private String[] username_database;
	private String[] password_database;

	public static File file = new File(
			// "D:\\git\\TNI-Hotel-booking-system\\TNI-Hotel-booking-system\\Database\\user_database.txt");
			"C:\\Users\\Yossapon Jantarote\\git\\TNI-Hotel-booking-system\\TNI-Hotel-booking-system\\Database\\user_database.txt");

	public LoginManager() {
		this.username = "";
		this.password = "";
	}

	public LoginManager(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public boolean LoginCheck() {
		// Change in into files reader when is this system ok
		DatabaseCount();
		ReadData();
		for (int i = 0; i < username_database.length; i++) {
			if (this.username.equals(this.username_database[i]) && this.password.equals(this.password_database[i])) {
				return true;
			}
		}
		return false;
	}

	public void ReadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			int count = 0;
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				for (int i = 0; i < username_database.length; i++) {
					this.username_database[count] = data[0];
					this.password_database[count] = data[1];
				}
				count++;
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void DatabaseCount() {
		try {
			int count = 0;
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			while ((line = br.readLine()) != null) {
				count++;
			}
			br.close();
			username_database = new String[count];
			password_database = new String[count];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
