package com.Club_Manager.Main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.Club_Manager.Console.Logger;
import com.Club_Manager.GUI.Window;
import com.Club_Manager.Input.MakeMembers;
import com.Club_Manager.Input.Member;

public class Main {

	public Logger logger;
	public ArrayList<Member> members;
	public MakeMembers makeMembers;
	
	public Main() {
		logger = new Logger();
		makeMembers = new MakeMembers();
				
		DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		
		//Starting the window class
		new Window(this, logger);
		
		logger.log("-----Started Application-----" + df.format(calobj.getTime()) + "\n");
		members = makeMembers.getMembers();
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
	 * - Make it so that the "edit" JMenu is only visible if the logged in officer is an admin
	 * - THE EXTRA MILE: in the members tab, make a button on the bottom of the panel that would display an analysis of the 
	 * 	 Individual members, and the same button on the roster that would give it holistically 
	 */
	
}
