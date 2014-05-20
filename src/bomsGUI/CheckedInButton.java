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
		int nbrCheckedInBikes = 2;
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		StringBuilder sb = new StringBuilder();
		sb.append("Bike ID" + "\t" + "Bike Owner" + "\n" + "\n");
		sb.append("00001" + "\t" + "S" + "\n");
		sb.append("00002" + "\t" + "O" + "\n");
//		for (Bike b : bikeList) {
//			if (b.isCheckedIn()) {
//				sb.append(b.toString() + "\t" + b.getOwner() + "\n");
//				nbrCheckedInBikes++;
//			}
//		}
		String s = sb.toString();
		if (s.isEmpty()) {
			s = "No bikes are checked into the garage.";
		} else {
			s = s + "\n" + "Number of checked in bikes: " + nbrCheckedInBikes;
		}
		view.setText(s);

	}

	// public ArrayList getCheckedInBikes(){
	//
	// }

}
