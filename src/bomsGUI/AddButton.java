package bomsGUI;

import db.Bike;
import db.BikeOwner;
import db.DatabaseManager;

import javax.swing.*;

import java.awt.event.*;

public class AddButton extends JButton implements ActionListener {
	private BomsView view;
	private boolean fullList = false;

	public AddButton(BomsView view) {
		super("Add");
		this.view = view;
		addActionListener(this);
		setToolTipText("Add a bike or a bike owner.");
        checkFull();
	}

    private void checkFull() {
        int s = DatabaseManager.getDBM().getTable(Bike.modelName).size();
        if(s >= 5000) fullList = true;
        this.setEnabled(!fullList);
    }

	public void actionPerformed(ActionEvent e) {
		String ssn = JOptionPane.showInputDialog("Enter SSN of the bike owner");
		double social;
		  try {
			  social = Double.parseDouble(ssn);
          } catch (NumberFormatException nfe) {
             JOptionPane.showMessageDialog(null,"Input must be a number.");
             return;
          }
		  
		  
		BikeOwner bikeOwner = BikeOwner.getBySSN(ssn);
        

        Object[] options2 = { "Yes", "No" };

		if (bikeOwner != null) {
            int m = JOptionPane.showOptionDialog(null,
                    "Do you wish to add a bike to " + ssn, "Adding a bike",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options2, options2[0]);
            if (m == 0) {
                addBike(bikeOwner);
            }
		} else {
            int n = JOptionPane.showOptionDialog(null,"Do you wish to register a new bike owner with the entered SSN: " + ssn + "?", "Adding a bike owner",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options2, options2[0]);
            if(n == 0) {
                new RegistrationForm("Bike owner registation", ssn, view);
            }
        }
        checkFull();
	}

    private void addBike(BikeOwner bikeOwner) {
        Bike bike = new Bike(bikeOwner);
        bikeOwner.addBike();
        bike.save();
        view.boms.printBarcode(bike.getID());
        JOptionPane.showMessageDialog(null, "Bike successfully added.");
    }
}
