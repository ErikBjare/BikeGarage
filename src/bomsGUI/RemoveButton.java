package bomsGUI;

import javax.swing.*;

import db.DatabaseManager;

import java.awt.event.*;

public class RemoveButton extends JButton implements ActionListener {
	private BomsView view;

	public RemoveButton(BomsView view) {
		super("Remove");
		this.view = view;
		addActionListener(this);
		setToolTipText("Remove a bike or a bike owner.");
	}

	public void actionPerformed(ActionEvent e) {
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");

		// TODO: Hur tittar man om ssn eller namn finns i databasen? (1)
		// TODO: Ta bort BikeOwner (2) eller Bike (3)
		// TODO: Få upp cykelägerns (BikeOwner) cyklar (4)
		
		if (ssnOrName == null) {
			return;
		}
		
		boolean bikeOwnerExists = true;
		
		db.BikeOwner bikeOwner = null;
		
		db.Table bikeOwners =  DatabaseManager.getDBM().getTable("BikeOwner");
		for(db.Model m : bikeOwners) {
			db.BikeOwner bo = (db.BikeOwner) m;
			System.out.println(bo.toString());
			System.out.println(bo.getSSN());
			if(bo.getSSN() == ssnOrName || bo.getName() == ssnOrName){
				bikeOwnerExists = true;
				bikeOwner = bo;
			}
		}
		

		
		
		
		 if (bikeOwnerExists) { // Checks if bike owner exists in database
			// TODO (1)
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
				// TODO (4)
				Object[] possibilities = { "Bike1", "Bike2", "Bike3" };
				String s = (String) JOptionPane
						.showInputDialog(null,
								"Select the bike you wish to remove:",
								"Removing a bike registered to " + ssnOrName,
								JOptionPane.PLAIN_MESSAGE, null, possibilities,
								"Bike1");

				if ((s != null) && (s.length() > 0)) {
					System.out.println("Removing " + s);
					// TODO (3)
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
