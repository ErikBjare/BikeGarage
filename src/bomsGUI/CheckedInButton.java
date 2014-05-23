package bomsGUI;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;

import java.awt.event.*;
import java.util.ArrayList;

public class CheckedInButton extends JButton implements ActionListener {
	private BomsView view;

	public CheckedInButton(BomsView view) {
		super("Checked In");
		this.view = view;
		addActionListener(this);
		setToolTipText("See which bikes are currently in the garage.");
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Knappen fungerar");
		ArrayList<Bike> checkedInBikes = Bike.getCheckedIn();
		StringBuilder sb = new StringBuilder();
		sb.append("Bike ID" + "\t" + "Bike Owner" + "\n" + "\n");
		for (Bike b : checkedInBikes) {
			sb.append(b.toString() + "\n");
		}
		String s = sb.toString();
			s = s + "\n" + "Number of checked in bikes: "
					+ checkedInBikes.size();
		view.setText(s);

	}


}
