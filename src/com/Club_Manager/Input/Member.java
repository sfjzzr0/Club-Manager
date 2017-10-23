package com.Club_Manager.Input;

import java.util.Arrays;

public class Member {

	public String[] dates;
	public String first, last, date;
	public int grade, id, attendance, khutbahs;
	
	public void addDate(String date) {
		String[] temp = new String[dates.length+1];
		
		for (int i = 0; i < dates.length; i ++) 
			temp[i] = dates[i];
		
		temp[temp.length-1] = date;
		dates = temp;

	}
	
	public Member(String first, String last, int id, int grade, String date, int attendance, int khutbahs, String[] dates) {
		this.first = first;
		this.last = last;
		this.id = id;
		this.grade = grade;
		this.date = date;
		this.attendance = attendance;
		this.khutbahs = khutbahs;
		this.dates = dates;
	}
	
	public String getDates() {
		
		String temp = " ";
		for (String str : dates) 
			temp += str + " ";
		
		return temp;
		
	}
	
	public String toString() {
		return first + " " + last + " " + id + " "+ grade + " " + date + " " + attendance + " " + khutbahs + getDates();
	}
	
}

/*
 * KEY:
 * [0]      [1]     [2]   [3]      [4]             [5]                 [6]
 * [FIRST]  [LAST]  [ID]  [GRADE]  [MEMBER SINCE]  [MEETINGS ATTENDED] [KHUTBAHS]
 */
