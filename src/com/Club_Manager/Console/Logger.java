package com.Club_Manager.Console;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
		
		lines = new ArrayList<String>();

	}
	
	public void log(String date, String temp) {
		lines.add(date + ": " + temp);
	}
	
	public void log(String temp) {
		lines.add(temp);
	}
	
	public void write() { //This runs when the program is about to close to save all of the progress
		try {
			out = new PrintWriter(new File("./src/com/Club_Manager/Resources/Log.txt"));
			
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
			scanner = new Scanner(new File("./src/com/Club_Manager/Resources/Log.txt"));
			
			while (scanner.hasNext()) {
				temp.add(scanner.nextLine());
			}
			
			if (temp.size() >= 1000){
				JOptionPane.showMessageDialog(new JFrame(),
					    "The log file has accumulated a lot of data, it is recommended to empty the file out",
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
	
}
