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
		
	}

}
