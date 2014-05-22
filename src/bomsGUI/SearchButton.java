package bomsGUI;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;
import db.DatabaseManager;

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
        String ssnOrName = JOptionPane
                .showInputDialog("Enter SSN or name of the bike owner");

        if (ssnOrName == null) {
            return;
        }

        BikeOwner bikeOwner = BikeOwner.getByName(ssnOrName);
        System.out.println(bikeOwner);

        if (bikeOwner == null) {
            System.out.println("Could not find BikeOwner");
            return;
        }

        BikeOwner[] bikeOwners = new BikeOwner[1];
        bikeOwners[0] = bikeOwner;

        /**
		BikeOwner bertil = new BikeOwner("Bertil", "89", "lele@lala");
		bertil.addBike(new Bike(bertil));
		bertil.addBike(new Bike(bertil));
		bertil.addBike(new Bike(bertil));
		bertil.addBike(new Bike(bertil));
		
		BikeOwner merta = new BikeOwner("Merta", "92", "lawl@epixx");
		merta.addBike(new Bike(bertil));
		merta.addBike(new Bike(bertil));
		merta.addBike(new Bike(bertil));

		bikeOwners[0] = bertil;
		bikeOwners[1] = merta;

         */

    	SearchResultFrame srf = new SearchResultFrame(bikeOwners, view);
	}

}
