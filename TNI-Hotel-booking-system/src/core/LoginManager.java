package core;

import java.io.*;

public class LoginManager {
	private String username;
	private String password;
	
	public FileReader reader = new FileReader(".\\Database\\user_database.txt");
	
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
	public boolean LoginCheck() { //Change in into files reader when is this system OK.
		if (this.username != username) {
			return false;
		}
		if (this.password != password) {
			return false;
		}
		return true;
	}
	
	public String getLoginStatus(String username,String password) {
		if (!LoginCheck()) {
			return "USERNAME or PASSWORD is wrong!";
		}
		return "";
	}

}
