package com.Club_Manager.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MakeMembers {

	boolean membersMade = false;
	ArrayList<Member> members;
	
	public void saveMembers() {
		try {
			PrintWriter out = new PrintWriter(new File("./src/com/Club_Manager/Resources/Members.data"));
			
			for (Member member : members) {
				out.println(member.toString());
			}
			out.close();
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "Something wrong happened and the process to saving the members was interrupted. Please check over the file"
				    + " to see that nothing was accediantly deleted.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public MakeMembers() {
		members = new ArrayList<Member>();
		
		try {
			Scanner s = new Scanner(new File("./src/com/Club_Manager/Resources/Members.data"));
			
			while (s.hasNextLine()) {
				String[] temp = s.nextLine().split(" ");
				if (temp.length >= 7) {
					members.add(new Member(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), temp[4],
						Integer.parseInt(temp[5]), Integer.parseInt(temp[6]), getArr(temp)));
				}
			}
			s.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(new JFrame(),
					"The member file was not found! Please check the path in the code.",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(new JFrame(),
				    "There was an error with one of the member's information in the file \"Members.data\"",
				    "Warning",
				    JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public String[] getArr(String[] temp) {
		String[] arr = new String[temp.length-7];
		for (int i = 0; i < arr.length; i ++){
			arr[i] = temp[i+7];
		}
		return arr;
	}
	
	public ArrayList<Member> getMembers() {
		return members;
	}
	
}

/*
 * KEY:
 * [0]      [1]     [2]   [3]      [4]             [5]                 [6]
 * [FIRST]  [LAST]  [ID]  [GRADE]  [MEMBER SINCE]  [MEETINGS ATTENDED] [KHUTBAHS]
 */
