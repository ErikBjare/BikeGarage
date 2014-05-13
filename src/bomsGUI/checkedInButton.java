package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class checkedInButton extends JButton implements ActionListener {
	private bomsView view;
	
	public checkedInButton(bomsView view) {
		super("Checked In");
		this.view = view;
		addActionListener(this);
		setToolTipText("See which bikes are currently in the garage.");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fungerar");
		//ToDo
	}

}
