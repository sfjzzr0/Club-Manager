package com.Club_Manager.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Logger {

	public Scanner scanner;
	public PrintWriter out;
	ArrayList<String> lines;
	ArrayList<String> prevLines;
	
	public Logger () {
		prevLines = readFile();
		prevLines.add("\n");
		
		lines = new ArrayList<String>();

	}
	
	public void logAction(String temp) {
		lines.add(getDate() + ": " + temp);
	}
	
	public void log(String temp) {
		lines.add(temp);
	}
	
	public void write() { //This runs when the program is about to close to save all of the progress
		try {
			out = new PrintWriter(new File("./src/com/Club_Manager/Resources/Log.data"));
			
			for (String s : prevLines)
				out.println(s);
			
			for (String s : lines)
				out.print(s);
			
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> readFile() {
		ArrayList<String> temp = new ArrayList<String>();
		try {
			scanner = new Scanner(new File("./src/com/Club_Manager/Resources/Log.data"));
			
			while (scanner.hasNext()) {
				temp.add(scanner.nextLine());
			}
			
			if (temp.size() >= 1000){
				JOptionPane.showMessageDialog(new JFrame(),
					    "The log file has accumulated a lot of data, it is recommended to empty the file out or the application might run slower than usual",
					    "Warning",
					    JOptionPane.WARNING_MESSAGE);
			}
			scanner.close();
			return temp;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		return df.format(calobj.getTime());
	}
	
}
