package core;

import java.io.*;

public class LoginManager {
	private String username;
	private String password;
	private String username_database;
	private String password_database;

	public static File file = new File(
			"D:\\git\\TNI-Hotel-booking-system\\TNI-Hotel-booking-system\\Database\\user_database.txt");

	public LoginManager() {
		this.username = "";
		this.password = "";
		this.username_database = "";
		this.password_database = "";
	}

	public LoginManager(String username, String password) {
		this.username = username;
		this.password = password;
		this.username_database = "";
		this.password_database = "";
	}

	public String getUsername() {
		return this.username;
	}

	public boolean LoginCheck() {
		// Change in into files reader when is this system ok
		ReadData();
		if (this.username.equalsIgnoreCase(this.username_database)
				&& this.password.equalsIgnoreCase(this.password_database)) {
			return true;
		}
		return false;
	}

	// public String getLoginStatus() {
	// if (!LoginCheck()) {
	// return "USERNAME or PASSWORD is wrong!";
	// }
	// return "Welcome" + getUsername();
	// }

	public void ReadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				this.username_database = data[0];
				this.password_database = data[1];
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
