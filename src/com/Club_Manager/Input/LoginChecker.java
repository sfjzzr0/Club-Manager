package com.Club_Manager.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.Club_Manager.GUI.OfficerLogin;

//This class will recall the resources of the officers to check if the person logging has access
public class LoginChecker {

	//To store the fields entered by the officer
	String username;
	String password;
	
	//This HashMap will store the correct login information
	HashMap<String, String> officers;
	
	//To store info of the officers whch includes their name
	ArrayList<String> Info;
	
	//Object of the higher level class
	OfficerLogin officerLogin;
	
	//Will be used to check if there was a new officer added
	public boolean new_officer_added = false;
	
	public void saveNewOfficer() {
		try {
			PrintWriter out = new PrintWriter(new File("./src/com/Club_Manager/Resources/Login.data"));
			
			for (String str : Info){
				out.println(str);
			}
			out.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Could not save the new officer! Please check the file and preform any neccessary functions.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	
	}
	
	public boolean addOfficer(String username, String password, String first, String last) {
		if (officers.containsKey(username)) {
			return false;
		} else {
			Info.add(username + " " + password + " " + first + " " + last);
			officers.put(username, password);
			new_officer_added = true;
			return true;
		}
	}
	
	public LoginChecker(OfficerLogin officerLogin) {
		//Assigns the reference to the object container
		this.officerLogin = officerLogin;
		
		//Initializes the correct map of usernames and passwords
		officers = new HashMap<String, String>();
		Info = new ArrayList<String>();
		readFile();
	}
	
	public void readFile() {
		try {
			Scanner scanner = new Scanner(new File("./src/com/Club_Manager/Resources/Login.data"));
			String str;
			while (scanner.hasNext()) {
				str = scanner.nextLine();
				Info.add(str);
				String[] temp = str.split(" ");
				if (temp.length >= 2)
					officers.put(temp[0], temp[1]);
				else 
					officerLogin.window.logger.logAction("[ERROR] - Officer login file has an error...");
			}
			
			scanner.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					"Could not load officer usernames and passwords! Please check the file and preform any neccessary functions.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
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
