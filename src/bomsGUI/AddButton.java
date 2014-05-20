package bomsGUI;

import javax.swing.*;

import java.awt.event.*;

public class AddButton extends JButton implements ActionListener {
	private BomsView view;
	// TODO fullList ska titta med databasen
	private boolean fullList = false;

	public AddButton(BomsView view) {
		super("Add");
		this.view = view;
		addActionListener(this);
		setToolTipText("Add a bike or a bike owner.");
		this.setEnabled(!fullList);

	}

	public void actionPerformed(ActionEvent e) {

		String ssn = JOptionPane.showInputDialog("Enter SSN of the bike owner");

		if (ssn == null) {
			return;
		} else if (ssn.equals("Filip") || ssn.equals("01")) {
			Object[] options2 = { "Yes", "No" };
			int m = JOptionPane.showOptionDialog(null,
					"Do you wish to add a bike to " + ssn, "Adding a bike",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options2, options2[0]);
			if (m == 0) {
				// bikeOwner.add(new Bike());
				JOptionPane
						.showMessageDialog(
								null,
								"Bike succesfully added." );
			}
		}

		// TODO
		this.setEnabled(!fullList);
	}

}