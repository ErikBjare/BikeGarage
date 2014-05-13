package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class removeButton extends JButton implements ActionListener {
	private bomsView view;
	
	public removeButton(bomsView view) {
		super("Remove");
		this.view = view;
		addActionListener(this);
		setToolTipText("Remove a bike or a bike owner.");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fungerar");
		//ToDo
	}

}
