package core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LoginManager {
	private String username;
	private String password;
	private List<String> username_database = new ArrayList<String>();
	private List<String> password_database = new ArrayList<String>();

	private File file = new File(getClass().getClassLoader().getResource("user_database.txt").getFile());

	public LoginManager(String username, String password) {
		ReadData();
		this.username = username;
		this.password = password.toLowerCase();
	}

	public String getUsername() {
		return username;
	}

	public boolean LoginCheck() {
		// Change in into files reader when is this system ok
		passwordDecode();
		for (int i = 0; i < username_database.size(); i++) {
			if (this.username.equals(this.username_database.get(i))
					&& this.password.equals(this.password_database.get(i))) {
				return true;
			}
		}
		return false;
	}

	public void ReadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				this.username_database.add(data[0]);
				this.password_database.add(data[1]);
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "File not found");
		}

	}

	public void passwordDecode() {
		String enText = "";
		int shift = 17;
		for (int i = 0; i < password.length(); i++) {
			if (Character.isDigit(password.charAt(i)))
				enText += password.charAt(i);
			else {
				char c = (char) (password.charAt(i) + shift);
				if (c > 'z')
					enText += (char) (password.charAt(i) - (26 - shift));
				else
					enText += (char) (password.charAt(i) + shift);
			}

		}
		this.password = enText;
	}
}