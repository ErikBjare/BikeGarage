package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class printBarcodeButton extends JButton implements ActionListener {
	private bomsView view;
	
	public printBarcodeButton(bomsView view) {
		super("Print Barcode");
		this.view = view;
		addActionListener(this);
		setToolTipText("Prints a barcode.");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fungerar");
		//ToDo
	}

}
