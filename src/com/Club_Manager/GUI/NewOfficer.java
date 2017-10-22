package com.Club_Manager.GUI;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewOfficer extends JPanel {
	
	Window window;
	
	JLabel title;
	JLabel[] labels;
	JTextField[] fields;
	
	public NewOfficer (Window window) {
		this.window = window;
		title = new JLabel("To induct a new officer, please fill out the form below:");
		labels = new JLabel[6];
		fields = new JTextField[6];
		
		String[] tempLabels = {"  Admin Username:  ", "  Admin Password:  ","      First Name:  ", "       Last Name:  ",
				"Officer Username:  ", "Officer Password:  "};
		for (int i = 0; i < tempLabels.length; i ++) {
			labels[i] = new JLabel(tempLabels[i]);
			labels[i].setFont(new Font("Arial", 0, 20));
			
			fields[i] = new JTextField();
			fields[i].setSize((int)labels[0].getPreferredSize().getWidth(), (int)labels[0].getPreferredSize().getHeight());
			fields[i].setFont(new Font("Arial", 0, 20));
		}
		fields[1] = new JPasswordField();
		fields[5] = new JPasswordField();
		
		tick();
		addAllElements();
	}
	
	public void tick() {
		int y = window.getHeight() / 3;
		for (int i = 0; i < labels.length; i ++) {
			labels[i].setBounds( (int)(window.getWidth()/2 - labels[i].getPreferredSize().getWidth()), y,  
					(int)labels[i].getPreferredSize().getWidth(), (int)labels[i].getPreferredSize().getHeight());
			
			fields[i].setBounds( (int)(window.getWidth()/2 + fields[i].getPreferredSize().getWidth()), y,  
					(int)labels[0].getPreferredSize().getWidth(), (int)labels[0].getPreferredSize().getHeight());
			
			
			y += labels[i].getPreferredSize().height * 2;
		}
		repaint();
	}
	
	public void addAllElements() {
		for (JLabel label : labels)
			add(label);
		
		for (JTextField field : fields)
			add(field);
	}
	
}
