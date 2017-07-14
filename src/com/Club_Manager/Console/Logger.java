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
	
	public Logger () {
		lines = new ArrayList<String>();
		lines.add("hello");
		lines.add("fef");
	}
	
	public void log(String date, String temp) {
		
	}
	
	public void log(String temp) {
		
	}
	
	public void write() {
		try {
			out = new PrintWriter(new File("./src/com/Club_Manager/Resources/Log.txt"));
			
			for (String s : readFile())
				System.out.println(s);
			
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
			System.out.println(temp.size());
			return temp;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
