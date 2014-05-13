package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class searchButton extends JButton implements ActionListener {
	private bomsView view;
	
	public searchButton(bomsView view) {
		super("Search");
		this.view = view;
		addActionListener(this);
		setToolTipText("Search after a bike owner");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fungerar");
		//ToDo
	}

}
