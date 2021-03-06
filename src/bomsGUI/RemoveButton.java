package bomsGUI;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RemoveButton extends JButton implements ActionListener {
	private BomsView view;

	public RemoveButton(BomsView view) {
		super("Remove");
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.view = view;
		addActionListener(this);
		setToolTipText("Remove a bike or a bike owner.");
	}

	public void actionPerformed(ActionEvent e) {
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");

		if (ssnOrName == null) return;

		BikeOwner bikeOwner;
        bikeOwner = BikeOwner.getByName(ssnOrName);
        if(bikeOwner == null) bikeOwner = BikeOwner.getBySSN(ssnOrName);
		
	    if (bikeOwner != null) { // Checks if bike owner exists in database
			Object[] options1 = {
					"Remove the bike owner.",
					"Remove a bike.", "Cancel" };
			int n = JOptionPane.showOptionDialog(null,
					"Choose one of the following options for the bike owner "+ ssnOrName,
					"Remove a bike or a bike owner",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options1, options1[2]);

			if (n == 0) {
				Object[] options2 = { "Yes", "No" };
				int m = JOptionPane.showOptionDialog(null,
						"Are you sure you wish to remove: " + ssnOrName
								+ " from the database?",
						"Removing a bike owner", JOptionPane.YES_NO_OPTION,
						JOptionPane.WARNING_MESSAGE, null, options2,
						options2[0]);
				if (m == 0) {
					System.out.println("Remove the bike owner " + ssnOrName);
					bikeOwner.removeAllBikes();
					bikeOwner.remove();
				}
			} else if (n == 1) {
				ArrayList<Bike> bikes = bikeOwner.getBikes();

				ArrayList<String> bikeIDs = new ArrayList<String>();
				for(Bike bike : bikes){
					bikeIDs.add(bike.getID());
				}
				Object[] choosableBikes = bikeIDs.toArray();
				String s = (String) JOptionPane
						.showInputDialog(null,
								"Select the bike you wish to remove:",
								"Removing a bike registered to " + ssnOrName,
								JOptionPane.PLAIN_MESSAGE, null, choosableBikes,
								"Bike1");

				if ((s != null) && (s.length() > 0)) {
					System.out.println("Removing " + s);
					bikeOwner.removeBike(bikes.get(bikeIDs.indexOf(s)));
				}

			}
		} else {
			JOptionPane
					.showMessageDialog(
							null,
							"No bike owners with the entered information are registered.",
							"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
