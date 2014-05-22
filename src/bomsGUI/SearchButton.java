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
		
		BikeOwner[] bikeOwners = new BikeOwner[2];
		
		BikeOwner bertil = new BikeOwner("Bertil", "89", "lele@lala");
		bertil.addBike(new Bike(bertil, "02"));
		bertil.addBike(new Bike(bertil, "03"));
		bertil.addBike(new Bike(bertil, "04"));
		bertil.addBike(new Bike(bertil, "06"));
		
		BikeOwner merta = new BikeOwner("Merta", "92", "lawl@epixx");
		merta.addBike(new Bike(bertil, "01"));
		merta.addBike(new Bike(bertil, "05"));
		merta.addBike(new Bike(bertil, "07"));
		
		
		bikeOwners[0] = bertil;
		bikeOwners[1] = merta;
		
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");
		if (ssnOrName == null) {
			return;

		} else if (ssnOrName.equals("Filip") || ssnOrName.equals("01")) {

			SearchResultFrame srf = new SearchResultFrame(bikeOwners, view);
			
		}
	}

}
