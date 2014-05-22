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
//		testCheckedIn(checkedInBikes);
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
	
//	public void testCheckedIn(ArrayList<Bike>checkedInBikes){
//		checkedInBikes.add(new Bike(new BikeOwner("00001", "01", "01")));
//		checkedInBikes.add(new Bike(new BikeOwner("00002", "02", "02")));
//		checkedInBikes.add(new Bike(new BikeOwner("00003", "03", "03")));
//		checkedInBikes.add(new Bike(new BikeOwner("00004", "04", "04")));
//	}

}
