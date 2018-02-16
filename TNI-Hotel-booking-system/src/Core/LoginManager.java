package Core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class LoginManager {
	private String username;
	private String password;
	private List<String> username_database = new ArrayList<String>();
	private List<String> password_database = new ArrayList<String>();

	public LoginManager(String username, String password) {
		this.username = username;
		this.password = password.toLowerCase();
	}

	public LoginManager() {
		this.username = "";
		this.password = "";
	}

	public String getUsername() {
		return username.toUpperCase().charAt(0) + username.toLowerCase().substring(1);
	}

	public boolean LoginCheck() {
		ReadData();
		if (username.isEmpty() && password.isEmpty()) {
			JOptionPane.showMessageDialog(null, "please enter username or password", "Message",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		for (int i = 0; i < username_database.size(); i++) {
			if (this.username.equalsIgnoreCase(this.username_database.get(i))
					&& this.password.equals(this.password_database.get(i))) {
				return true;
			}
		}
		JOptionPane.showMessageDialog(null, "username or password is incorrect.", "Message",
				JOptionPane.WARNING_MESSAGE);
		return false;
	}

	public void ReadData() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("res//Database//user_database.txt"));
			String line; // Read Data from database
			while ((line = br.readLine()) != null) {
				String[] data = line.split(";");
				String username = data[0];
				String password = data[1];
				int hash = Integer.parseInt(data[2]);
				this.username_database.add(username);
				this.password_database.add(PasswordDecode(password, hash));
			}
			br.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Database not found.", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Database error", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	private String PasswordDecode(String password, int hash) {
		String deText = "";
		for (int i = 0; i < password.length(); i++) {
			// ถ้าเป็นตัวเลขจะข้าม
			if (Character.isDigit(password.charAt(i)))
				deText += password.charAt(i);
			else {
				// ทำการลองแปลงตัวอักษร
				char c = (char) (password.charAt(i) - hash);
				// ถ้าแปลงแล้วตัวอักษรน้อยกว่า a เอาตัวอักษรนั้น + (26-hash)
				if (c < 'a')
					deText += (char) (password.charAt(i) + (26 - hash));
				else
					deText += (char) (password.charAt(i) - hash);
			}
		}
		return deText;
	}

}