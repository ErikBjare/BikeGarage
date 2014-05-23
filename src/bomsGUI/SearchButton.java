package bomsGUI;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;
import db.DatabaseManager;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SearchButton extends JButton implements ActionListener {
	private BomsView view;

	public SearchButton(BomsView view) {
		super("Search");
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        
        
        ArrayList<BikeOwner> arrayListBikeOwners = BikeOwner.findByNameOrSSN(ssnOrName);
        BikeOwner[] bikeowners = arrayListBikeOwners.toArray(new BikeOwner[arrayListBikeOwners.size()]);
        
        if (bikeowners.length == 0) {
            JOptionPane.showMessageDialog(null,"No bike owners with the entered information are registered");
            return;
        }

    	SearchResultFrame srf = new SearchResultFrame(bikeowners, view);
	}

}
