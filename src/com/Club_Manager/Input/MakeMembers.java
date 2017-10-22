package com.Club_Manager.Input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MakeMembers {

	boolean membersMade = false;
	ArrayList<Member> members;
	
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
			// TODO Auto-generated catch block
			System.out.println("The member file was not found! Please check the path in the code.");
		} catch (NumberFormatException e) {
			System.out.println("There was an error with one of the member's information in the file \"Members.data\"");
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
