package com.Club_Manager.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.Club_Manager.Console.Logger;
import com.Club_Manager.GUI.Window;

public class Main {

	public Logger logger;
	
	public Main() {
		logger = new Logger();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		//Starting the window class
		new Window(this, logger);
		
		logger.log("-----Started Application-----" + df.format(calobj.getTime()) + "\n");
	}
	
	public void log (String temp) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));
		
		logger.log(df.format(calobj.getTime()), temp);
	}
	
	public String getDate() {
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
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
	 * - if time permits be able to log when the program is running and not right before it closes to make sure that
	 *   even of the program stops, you can still see what was being done
	 */
	
}
