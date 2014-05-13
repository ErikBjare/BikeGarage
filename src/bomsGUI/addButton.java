package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class addButton extends JButton implements ActionListener {
	private bomsView view;
	
	public addButton(bomsView view) {
		super("Add");
		this.view = view;
		addActionListener(this);
		setToolTipText("Add a bike or a bike owner.");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen Add fungerar");
		//ToDo
	}

}
