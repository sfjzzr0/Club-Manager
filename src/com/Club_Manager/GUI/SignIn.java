package com.Club_Manager.GUI;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SignIn extends JPanel{

	Box box;
	Box horz;
	
	Window window;
	JPanel subPanel;
	JLabel dateLabel, instructions;
	JTextField dateEntry, idEntry;
	JButton signIn;
	
	public void addAllElements() {
		box = Box.createVerticalBox();
		horz = Box.createHorizontalBox();
		
		subPanel.add(dateLabel);
		subPanel.add(dateEntry);
		
		horz.add(Box.createHorizontalStrut(-270));
		horz.add(subPanel);
		horz.add(Box.createHorizontalGlue());
		
		box.add(horz);
		box.add(Box.createVerticalStrut(100));
		
		box.add(instructions);
		box.add(idEntry);
		box.add(signIn);
		
		add(box);

//		subPanel.add(Box.createRigidArea(new Dimension(0,5)));
//		subPanel.add(Box.createHorizontalGlue());
//		subPanel.add(Box.createRigidArea(new Dimension(10, 0)));
		
//		
//		add(subPanel);
//		add(instructions);
//		add(idEntry);
//		add(signIn);
	}
	
	public SignIn(Window window) {
		this.window = window;
		
		//Initialize all of the objects		
		subPanel = new JPanel();
		
		dateLabel = new JLabel("Today's Date: ");
		instructions = new JLabel("Enter School ID: ");
		
		dateEntry = new JTextField();
		idEntry = new JTextField();
		
		signIn = new JButton("Sign In");
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	//sets the correct layout 
		
		addAllElements(); 	//adds the components into the JPanel
	}
	
	public void tick() {
		dateEntry.setBounds(dateEntry.getX(), dateLabel.getY(), dateLabel.getWidth(), dateLabel.getHeight());
		idEntry.setBounds(instructions.getX(), instructions.getY()+30, dateLabel.getWidth()*2, dateLabel.getHeight());
		setVisible(true);
		
	}
	
}

