package bomsGUI;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;

import java.awt.event.*;

public class SearchButton extends JButton implements ActionListener {
	private BomsView view;

	public SearchButton(BomsView view) {
		super("Search");
		this.view = view;
		addActionListener(this);
		setToolTipText("Search after a bike owner");
	}

	public void actionPerformed(ActionEvent e) {
		
		BikeOwner[] bikeOwners = new BikeOwner[1];
		
		BikeOwner bertil = new BikeOwner("Bertil", "01", "@");
		bertil.addBike(new Bike(bertil, "01"));
		bertil.addBike(new Bike(bertil, "02"));
		bertil.addBike(new Bike(bertil, "03"));
		bertil.addBike(new Bike(bertil, "04"));
		
		bikeOwners[0] = bertil;

		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");
		if (ssnOrName == null) {
			return;

		} else if (ssnOrName.equals("Filip") || ssnOrName.equals("01")) {

			SearchResultFrame srf = new SearchResultFrame(bikeOwners, view);
			
		}
	}

}
