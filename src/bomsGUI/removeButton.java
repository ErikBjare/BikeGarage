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

	public void actionPerformed(ActionEvent e) {
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");

		// TODO: Hur tittar man om ssn eller namn finns i databasen? (1)
		// TODO: Ta bort BikeOwner (2) eller Bike (3)
		// TODO: Få upp cykelägerns (BikeOwner) cyklar (4)
		if (ssnOrName == null) {
			return;
		} else if (ssnOrName.equals("Filip") || ssnOrName.equals("01")) {
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
					// TODO (2)
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

				// If you're here, the return value was null/empty.
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
