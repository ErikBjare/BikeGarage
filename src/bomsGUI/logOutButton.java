package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class logOutButton extends JButton implements ActionListener {
	private bomsView view;
	
	public logOutButton(bomsView view) {
		super("Log Out");
		this.view = view;
		addActionListener(this);
		setToolTipText("Log out.");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fungerar");
		//ToDo
	}

}
