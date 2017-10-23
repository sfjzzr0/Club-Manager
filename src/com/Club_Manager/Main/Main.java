package com.Club_Manager.Main;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.Club_Manager.Console.Logger;
import com.Club_Manager.GUI.Window;
import com.Club_Manager.Input.MakeMembers;
import com.Club_Manager.Input.Member;

public class Main {

	public Logger logger;
	public ArrayList<Member> members;
	public MakeMembers makeMembers;
	
	public void SignIn(String tempId, String date) {
		try {
			int index = findMember(Integer.parseInt(tempId));
			
			if (index != -1) {
				members.get(index).addDate(date);
				logger.logAction("[" + members.get(index).first + " " + members.get(index).last + "] successfully signed in with"
						+ "the id [" + tempId + "] to the date [" + date + "]");
			}
			else {
				logger.logAction("A student with the ID [" + tempId + "] attempted to sign in but was not found in the members"
						+ "directory");
				idError(1);
			}
			
		} catch (NumberFormatException e) {
			idError(0);
		}
		
	}
	
	public int findMember(int id) {
		
		for (int i = 0; i < members.size(); i ++) 
			if (members.get(i).id == id)
				return i;
		
		
		return -1;
	}
	
	public void idError(int x) {
		//if x == 0, then the user entered an id with letters in it
		if (x == 0) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "The ID that you entered had letters typed in it. Please try again!",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
		
		//If x == 1, then the user entered an id that could not be found
		else if (x == 1) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "The ID that you entered could not be found! Please register as a member first and then try again.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public Main() {
		logger = new Logger();
		makeMembers = new MakeMembers();
		
		//Starting the window class
		new Window(this, logger);
		
		logger.log("-----Started Application-----" + logger.getDate() + "\n");
		members = makeMembers.getMembers();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

	/* Control+Option+Space
	 * TODO:
	 * - fix the layout and placement of the officer login elements
	 * - make the "tick()" method more efficient 
	 * - make sure program logs everything
	 * - if time permits be able to log when the program is running and not right before it closes to make sure that
	 *   even of the program stops, you can still see what was being done
	 * - Make it so that the "edit" JMenu is only visible if the logged in officer is an admin
	 * - THE EXTRA MILE: in the members tab, make a button on the bottom of the panel that would display an analysis of the 
	 * 	 Individual members, and the same button on the roster that would give it holistically 
	 * - Maybe sort the Members Arraylist by their names
	 * - make the NewMember class
	 */
	
}
