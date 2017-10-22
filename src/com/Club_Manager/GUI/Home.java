package com.Club_Manager.GUI;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Home extends JPanel{

	Window window;
	SignIn signIn;
	MembersList membersList;
	Roster roster;
	
	JMenuBar menuBar;
	JMenu file, edit, view;
	JMenuItem importMembers, export, reset, viewLog;	//All of these will be under "File" except for "reset" 
	JMenuItem newWindow, editRoster;
	//NOTE: a JMenu is an item added that groups up multiple JMenuItem
	
	JTabbedPane tabbedPane;
	public void tick() {
		if (tabbedPane.getSelectedComponent() != null && tabbedPane.getSelectedComponent().equals(signIn))
			signIn.tick();
		else if (tabbedPane.getSelectedComponent() != null && tabbedPane.getSelectedComponent().equals(membersList))
			membersList.tick();
		else if (tabbedPane.getSelectedComponent() != null && tabbedPane.getSelectedComponent().equals(roster))
			roster.tick();
	}
	
	public Home(Window window) {
		this.window = window;
		
		//Initializing all of the variables 
		signIn = new SignIn(window); //add all of the other tabs right here
		membersList = new MembersList(window);
		roster = new Roster(window);
		
		menuBar = new JMenuBar();
		file = new JMenu("File");
//		edit = new JMenu("Edit");  This will be implemented later to be seen only by the admin to edit the officer list
		view = new JMenu("View");
		importMembers = new JMenuItem("");
		export = new JMenuItem("");
		reset = new JMenuItem("");
		viewLog = new JMenuItem("");
		
		tabbedPane = new JTabbedPane();
		
		//adding sub-elements to the menuBar
		file.add(importMembers);
		file.add(export);
		file.add(viewLog);
//		edit.add(reset);
		
		menuBar.add(file);
//		menuBar.add(edit); To be implemented later --- check above for note
		menuBar.add(view);
		
		tabbedPane.add("tab 1", signIn);
		tabbedPane.add("Members", membersList);
		tabbedPane.add("Roster", roster);
		
		this.window.setJMenuBar(menuBar);
		this.window.add(tabbedPane);
		window.setVisible(true);
	}
}
