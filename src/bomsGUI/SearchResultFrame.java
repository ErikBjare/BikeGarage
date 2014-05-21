package bomsGUI;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import db.Bike;
import db.BikeOwner;

public class SearchResultFrame {

	public SearchResultFrame(BikeOwner[] bikeOwners, final BomsView view) {

		JFrame f = new JFrame();
		final JList list = new JList(bikeOwners);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {

				SearchResultFrame srf = new SearchResultFrame(
						((BikeOwner) list.getSelectedValue()).getBikes(), view);

			}

		};
		list.addListSelectionListener(listSelectionListener);

		f.add(new JScrollPane(list));
		f.setSize(200, 500);
		f.setVisible(true);
	}

	public SearchResultFrame(ArrayList<Bike> bikes, BomsView view) {
		
		String[] lawl = {"01", "02", "03"};

		JFrame f = new JFrame();
		final JList list = new JList(lawl);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {

				System.out.println("YOLOF");
			}

		};
		list.addListSelectionListener(listSelectionListener);

		f.add(new JScrollPane(list));
		f.setSize(200, 500);
		f.setVisible(true);

	}
}
