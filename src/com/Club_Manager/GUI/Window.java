package com.Club_Manager.GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.Club_Manager.Console.Logger;
import com.Club_Manager.Main.Main;

public class Window extends JFrame implements ActionListener{
	
	public OfficerLogin officerLogin;
<<<<<<< HEAD
	public BorderLayout borderLayout;
=======
	public NewOfficer newOfficer;
>>>>>>> origin/master
	public Home home;
	public Timer timer;
	public Main main;
	public Logger logger;
	
	public String programState = "Officer Login";	//This will be used to keep track of what the program has to display
													//More info on the different states can be found in the ActionPerformed method
	public final int WIDTH = 750;
	public final int HEIGHT = 1000;
	
	public void login() {
		programState = "Home [default]";
		home = new Home(this);
		getContentPane().remove(officerLogin);	
		setBorderLayout();
		add(home, BorderLayout.CENTER);
		getContentPane().invalidate();	//This and the line after it forces the frame to be redrawn along with 
		getContentPane().validate();	//its subcomponents 
	}
	
	public void setBorderLayout() {
		borderLayout = new BorderLayout();
		setLayout(borderLayout);
	}
	
	public void openNewOfficer() {
		programState = "New Officer";
		newOfficer = new NewOfficer(this);
		add(newOfficer);
		repaint();
		setVisible(true);
	}
	
	public void createTimer() {
		timer = new Timer(10,this);
	}
	
	public void startTimer() {
		timer.start();
	}
	
	public Window(Main main, Logger logger) {
		//Initializing the JFrame super class
		super("Officer Manager");
		
		this.main = main;
		this.logger = logger;
		
		setSize(HEIGHT, WIDTH);
		setResizable(true);
		setLocationRelativeTo(null);
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e)
		    {
		       exit();
		    }
		});
		
		//Initializing OfficerLogin's elements
		if (programState.equals("Officer Login")) {
			officerLogin = new OfficerLogin(this);
			add(officerLogin);
		}
		
		
		
		//Creates the update loop
		createTimer();
		startTimer();
		
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		 * The variable "programState" can exhibit different values to tell this Window class what to display
		 * the following is the key to the different values it can hold:
		 * - "Officer Login"
		 * - "New Officer"
		 * - "Home [default]"
		 * - "Home [members]"
		 * - "Home [roster]"
		 */
		
		if (programState.equals("Officer Login")){
			officerLogin.tick();
		}
		else if (programState.equals("New Officer")){
			newOfficer.tick();
		}
		else if (programState.equals("Home [default]")){
			home.tick();
		}
	}
	
	public void exit(){
		DateFormat df = new SimpleDateFormat("MM/dd/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		main.logger.log("-----Ended Application-----" + df.format(calobj.getTime()));
		main.logger.write();
		System.exit(0);
	}
	
}
