package com.Club_Manager.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.Club_Manager.Console.Logger;
import com.Club_Manager.GUI.Window;

public class Main {

	Logger logger;
	
	public Main() {
		//Starting the window class
		new Window(this);
		logger = new Logger();
	}
	
	public void log (String temp) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		
		logger.log(df.format(calobj.getTime()), temp);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	/* Control+Option+Space
	 * TODO:
	 * - fix the layout and placement of the officer login elements
	 * - "Window.java" line 40, implement how the program exits and saves files
	 * - if time permits, then see if you can underline the login button
	 * - check if the placements look nicer at those spots (for the login and new officer buttons)
	 * - make the "tick()" method more efficient 
	 * - implement the failedLogin() method
	 * - make sure program logs everything
	 */
	
}
