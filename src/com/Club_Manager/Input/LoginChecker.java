package com.Club_Manager.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.Club_Manager.GUI.OfficerLogin;

//This class will recall the resources of the officers to check if the person logging has access
public class LoginChecker {

	//To store the fields entered by the officer
	String username;
	String password;
	
	//This HashMap will store the correct login information
	HashMap<String, String> officers;
	
	//Object of the higher level class
	OfficerLogin officerLogin;
	
	public LoginChecker(OfficerLogin officerLogin) {
		//Assigns the reference to the object container
		this.officerLogin = officerLogin;
		
		//Initializes the correct map of usernames and passwords
		officers = new HashMap<String, String>();
		readFile();
	}
	
	public void readFile() {
		try {
			Scanner scanner = new Scanner(new File("./src/com/Club_Manager/Resources/Login.data"));
			
			while (scanner.hasNext()) {
				String[] temp = scanner.nextLine().split(" ");
				if (temp.length == 2)
					officers.put(temp[0], temp[1]);
				else 
					officerLogin.window.logger.logAction("[ERROR] - Officer login file has an error...");
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean check(String username, String password) {
		//Stores the variables permanently to the object
		this.username = username;
		this.password = password;
		
		officerLogin.window.logger.logAction("Username [" + username + "]" + "attempted login\n");
		
		if (officers.containsKey(username) && password.equals(officers.get(username))){
			officerLogin.window.logger.logAction("Username [" + username + "]" + "succeeded login\n");
			
			return true;
		}
		
		officerLogin.window.logger.logAction("Username [" + username + "]" + "failed login\n");
		
		return false;
	}
	
}
