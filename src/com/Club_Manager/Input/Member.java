package com.Club_Manager.Input;

public class Member {

	public String[] dates;
	public String first, last, date;
	public int grade, id, attendance, khutbahs;
	
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
	
}

/*
 * KEY:
 * [0]      [1]     [2]   [3]      [4]             [5]                 [6]
 * [FIRST]  [LAST]  [ID]  [GRADE]  [MEMBER SINCE]  [MEETINGS ATTENDED] [KHUTBAHS]
 */
