package com.Club_Manager.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewOfficer extends JPanel {
	
	Window window;
	
	JLabel title;
	JLabel[] labels;
	JTextField[] fields;
	JButton add, back;
	
	public int fieldWidth;
	
	public NewOfficer (Window window) {
		this.window = window;
		title = new JLabel("To add an officer to the list, please fill out the form below:");
		labels = new JLabel[6];
		fields = new JTextField[6];
		add = new JButton("Add Officer");
		back = new JButton("Back");
		
		title.setFont(new Font("Arial", 0, 30));
		add.setFont(new Font("Arial", 0, 20));
		back.setFont(new Font("Arial", 0, 20));
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				if (window.officerLogin.loginChecker.check(fields[0].getText(), fields[1].getText())){
					window.officerLogin.loginChecker.addOfficer(fields[4].getText(), fields[5].getText(), fields[2].getText(), fields[3].getText());
					window.logger.logAction("A new officer's info [" + fields[2].getText() + "\'s] was attempted to be added and succeeded");

				} else{
					window.logger.logAction("A new officer's info was attempted to be added but failed");
					JOptionPane.showMessageDialog(new JFrame(),
							"The administrator username or password is not correct!",
						    "Warning",
						    JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				window.closeNewOfficer();
			}
		});
		
		String[] tempLabels = {"  Admin Username:  ", "  Admin Password:  ","      First Name:  ", "       Last Name:  ",
				"Officer Username:  ", "Officer Password:  "};
		for (int i = 0; i < tempLabels.length; i ++) {
			labels[i] = new JLabel(tempLabels[i]);
			labels[i].setFont(new Font("Arial", 0, 25));
			
			fields[i] = new JTextField();
			fields[i].setSize((int)labels[0].getPreferredSize().getWidth(), (int)labels[0].getPreferredSize().getHeight());
			fields[i].setFont(new Font("Arial", 0, 25));
		}
		fields[1] = new JPasswordField();
		fields[5] = new JPasswordField();
		
		fieldWidth = (int)fields[0].getPreferredSize().getWidth();
		
		tick();
		addAllElements();
	}
	
	public void tick() {
		title.setBounds(window.getWidth()/2 - (int)title.getPreferredSize().getWidth()/2, window.getHeight()*3/20, 
				(int)title.getPreferredSize().getWidth(), (int)title.getPreferredSize().getHeight());
		
		int y = window.getHeight()*3/10;
		for (int i = 0; i < labels.length; i ++) {
			labels[i].setBounds( (int)(window.getWidth()/2 - labels[i].getPreferredSize().getWidth() - 10), y,  
					(int)labels[i].getPreferredSize().getWidth(), (int)labels[i].getPreferredSize().getHeight());
			
			fields[i].setBounds( (int)(window.getWidth()/2 + fieldWidth - 10), y,  
					(int)labels[0].getPreferredSize().getWidth(), (int)labels[0].getPreferredSize().getHeight());
			
			
			y += labels[i].getPreferredSize().height * 2;
		}

		add.setBounds(window.getWidth() - (int)add.getPreferredSize().getWidth() - 40, window.getHeight() - (int)add.getPreferredSize().getHeight() - 70,
				(int)add.getPreferredSize().getWidth(), (int)add.getPreferredSize().getHeight());
		
		back.setBounds(15, window.getHeight() - (int)back.getPreferredSize().getHeight() - 70,
				(int)back.getPreferredSize().getWidth(), (int)back.getPreferredSize().getHeight());
		
		repaint();
	}
	
	public void addAllElements() {
		add(title);
		
		for (JLabel label : labels)
			add(label);
		
		for (JTextField field : fields)
			add(field);
		
		add(add);
		add(back);
	}
	
}
