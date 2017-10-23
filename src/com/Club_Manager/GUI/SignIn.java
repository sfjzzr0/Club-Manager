package com.Club_Manager.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Club_Manager.Main.Main;

public class SignIn extends JPanel implements ActionListener {

	Box box;
	Box horz;
	
	Window window;
	Main main;
	JLabel dateLabel, instructions;
	JTextField dateEntry, idEntry;
	JButton signIn, today, newMember;
	
	public void addAllElements() {
		box = Box.createVerticalBox();
		horz = Box.createHorizontalBox();
		
		box.add(Box.createVerticalGlue());
		
		horz.add(Box.createRigidArea(new Dimension(10, 0)));
		horz.add(dateLabel);
		horz.add(Box.createRigidArea(new Dimension(5,0)));
		horz.add(dateEntry);
		horz.add(Box.createRigidArea(new Dimension(5,0)));
		horz.add(today);
		
		box.add(horz);
	//		box.add(Box.createVerticalStrut(10));
	//		box.add(Box.createHorizontalGlue());
		
		box.add(instructions);
		box.add(Box.createRigidArea(new Dimension(0, 50)));
		box.add(idEntry);
		box.add(signIn);
		box.add(newMember);
		
		add(box);
		window.getRootPane().setDefaultButton(signIn);
	}
	
	public SignIn(Window window) {
		this.window = window;
		this.main = window.main;
		
		//Initialize all of the objects		
		dateLabel = new JLabel("Today's Date (MM/DD): ");
		instructions = new JLabel("Enter School ID: ");
		
		dateEntry = new JTextField();
		idEntry = new JTextField();
		
		signIn = new JButton("Sign In");
		signIn.addActionListener(this);
		
		newMember = new JButton("Add New Member");
		newMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO implement the NewMember class
			}
		});
		
		today = new JButton("Today's Date?");
		today.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("MM/dd");
				Calendar calobj = Calendar.getInstance();
				dateEntry.setText(df.format(calobj.getTime()));
				main.logger.logAction("Today's date was set automatically in the Member Sign-In page");
			}
		});
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	//sets the correct layout 
		
		setFonts(new Font("Arial", Font.BOLD, 21));
		addAllElements(); 	//adds the components into the JPanel
	}
	
	public void setFonts(Font font) {
		dateLabel.setFont(font);
		instructions.setFont(font);
		dateEntry.setFont(font.deriveFont(0));
		idEntry.setFont(font.deriveFont(0));
		signIn.setFont(font);
		newMember.setFont(font);
		today.setFont(font.deriveFont(0, 18));
	}
	
	public void tick() {
		//The top part of where the date is entered
		dateLabel.setBounds(dateLabel.getX(), 20, dateLabel.getWidth(), dateLabel.getHeight());
		dateEntry.setBounds(dateEntry.getX(), 20, dateLabel.getWidth()/2, dateLabel.getHeight()+10);
		today.setBounds(dateEntry.getX()+dateEntry.getWidth(), 20, today.getWidth(), today.getHeight());
		
		//The middle portion where the student's ID's are entered along with the instruction label
		instructions.setBounds((window.getWidth()/2 - idEntry.getWidth()/2), window.getY()/2 + instructions.getWidth()/2,
				(int)instructions.getPreferredSize().getWidth(), (int)instructions.getPreferredSize().getHeight());
		idEntry.setBounds(instructions.getX(), instructions.getY()+30, dateLabel.getWidth()*3/2, dateLabel.getHeight()+10);
		
		//The sign in button 
		signIn.setBounds(window.getWidth() - (int)(signIn.getPreferredSize().getWidth() + 65), 
				window.getHeight() - (int)(signIn.getPreferredSize().getHeight() + 140), 
				(int)signIn.getPreferredSize().getWidth(), (int)signIn.getPreferredSize().getHeight());
		newMember.setBounds(10, window.getHeight() - (int)(newMember.getPreferredSize().getHeight() + 140),
				(int)newMember.getPreferredSize().getWidth(), (int)newMember.getPreferredSize().getHeight());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		main.SignIn(idEntry.getText(), dateEntry.getText());
		idEntry.setText("");
	}
	
}

