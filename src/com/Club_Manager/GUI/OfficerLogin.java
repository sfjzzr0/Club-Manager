package com.Club_Manager.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.Club_Manager.Input.LoginChecker;

public class OfficerLogin extends JPanel{

	public Window window;
	public LoginChecker loginChecker;
	
	public JLabel title;
	public JLabel username;
	public JLabel password;
	
	public JButton login;
	public JButton new_officer;
	
	public JTextField usernameField;
	public JPasswordField passwordField;
	
	
	public void tick() {
		//This method is invoked whenever this JPanel is visible
		
		//Sets the boundaries of the title
		title.setBounds(window.getWidth()/2-((int)title.getPreferredSize().getWidth())/2, window.getHeight()/5, 
				(int)title.getPreferredSize().getWidth(), (int)title.getPreferredSize().getHeight());

		//Sets the boundaries of the user-name
		username.setBounds(window.getWidth()/3-((int)username.getPreferredSize().getWidth()/2), window.getHeight()/6*2, 
				(int)username.getPreferredSize().getWidth(), (int)username.getPreferredSize().getHeight());

		//Sets the boundaries of the password
		password.setBounds(window.getWidth()/3-((int)password.getPreferredSize().getWidth()/2), window.getHeight()/6*3, 
				(int)password.getPreferredSize().getWidth(), (int)password.getPreferredSize().getHeight());
		
		//Sets the boundaries of the username entry box
		usernameField.setBounds((int) (username.getX() + username.getPreferredSize().getWidth() + 10), username.getY(),
				(int)password.getPreferredSize().getWidth()/3*5, (int)password.getPreferredSize().getHeight());
		
		//Sets the boundaries of the passwordField entry box
		passwordField.setBounds((int) (password.getX() + password.getPreferredSize().getWidth() + 10), password.getY(),
				(int)password.getPreferredSize().getWidth()/3*5, (int)password.getPreferredSize().getHeight());

		//Sets the boundaries of the Login Button
		login.setBounds(getWidth()-((int)(login.getPreferredSize().getWidth()) + 10), getHeight()-((int)(login.getPreferredSize().getHeight()) + 10), 
				(int)(login.getPreferredSize().getWidth()), (int)(login.getPreferredSize().getHeight()));

		//Sets the boundaries of the Login Button
		new_officer.setBounds(10, getHeight()-((int)(new_officer.getPreferredSize().getHeight()) + 10), 
				(int)(new_officer.getPreferredSize().getWidth()), (int)(new_officer.getPreferredSize().getHeight()));
		
	}
	
	public void LoginFailed() {
		JOptionPane.showMessageDialog(new JFrame(),
			    "The username or password that you entered was incorrect. Please try again!",
			    "Warning",
			    JOptionPane.WARNING_MESSAGE);
		
		usernameField.setText("");
		passwordField.setText("");
	}
	
	public void addAllElements() {
		add(title);
		add(username);
		add(password);
		add(usernameField);
		add(passwordField);
		add(login);
		add(new_officer);
		window.getRootPane().setDefaultButton(login);
	}
	
	public OfficerLogin(Window window) {
		super.setLayout(null);
		
		//Sets the variable window for future use
		this.window = window;
		
		//Initializes the LoginChecker
		loginChecker = new LoginChecker(this);
		
		//Initializing title attributes
		title = new JLabel("Officer Login:");
		title.setFont(new Font("Arial", 2, 35));
		
		//Initializing user-name attributes
		username = new JLabel("Username:");
		username.setFont(new Font("Arial", 0, 30));
				
		//Initializing password attributes
		password = new JLabel("Password:");
		password.setFont(new Font("Arial", 0, 30));
		
		//Initializing username entry box
		usernameField = new JTextField();
		usernameField.setToolTipText("Enter Username");
		usernameField.setFont(new Font("Arial", 0, 25));
		
		//Initializing password entry box
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Password");
		passwordField.setFont(new Font("Arial", 2, 20));
			
		//Initializing Login Button attributes
		login = new JButton();
		login.setText("Login");
		login.setFont(new Font("Arial", 0, 20));
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (loginChecker.check(usernameField.getText(), passwordField.getText())) {
					window.login();
				}
				else {
					LoginFailed();
				}
			}
		});

		//Initializing New Officer Button attributes
		new_officer = new JButton();
		new_officer.setText("Add New Officer");
		new_officer.setFont(new Font("Arial", 0, 20));
		new_officer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				window.openNewOfficer();
			}
			
		});
		
		addAllElements();
		tick();
				
	}
	
}
