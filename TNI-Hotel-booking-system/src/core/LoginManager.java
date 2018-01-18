package core;

import java.io.*;

public class LoginManager {
	private String username;
	private String password;

	public static File file = new File(
			"D:\\git\\TNI-Hotel-booking-system\\TNI-Hotel-booking-system\\Database\\user_database.txt");

	public LoginManager() {
		this.username = "";
		this.password = "";
	}

	public LoginManager(String username, String password) {

	}

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
