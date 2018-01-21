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

	public LoginManager() {
		this.username = "";
		this.password = "";
	}

	public LoginManager(String username, String password) {
		this.username = username;
		this.password = password.toLowerCase();
	}

	public String getUsername() {
		return username;
	}

	public boolean LoginCheck() {
		if (ReadData()) {
			PasswordDecode();
			for (int i = 0; i < username_database.size(); i++) {
				if (this.username.equals(this.username_database.get(i))
						&& this.password.equals(this.password_database.get(i))) {
					return true;
				}
				else {
					JOptionPane.showMessageDialog(null, "username or password is incorrect.","Message",JOptionPane.WARNING_MESSAGE);
					return false;
				}
			}
		}
		return false;
	}

	private boolean ReadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line; // Read Data from database
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				this.username_database.add(data[0]);
				this.password_database.add(data[1]);
			}
			br.close();
			return true;
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Database not found.","Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}

	}

	public void PasswordDecode() {
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
