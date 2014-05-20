package bomsGUI;

import javax.swing.*;

import java.awt.event.*;


public class SearchButton extends JButton implements ActionListener {
	private BomsView view;
	
	public SearchButton(BomsView view) {
		super("Search");
		this.view = view;
		addActionListener(this);
		setToolTipText("Search after a bike owner");
	}
	
	public void actionPerformed(ActionEvent e){
		System.out.println("Knappen fun2gerar");
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");
		
		//TODO
	}
	

}
