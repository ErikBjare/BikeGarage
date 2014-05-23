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

		JFrame f = new JFrame("Bike owners");
		final JList list = new JList<BikeOwner>(bikeOwners);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				ArrayList<Bike> bikes = ((BikeOwner) list.getSelectedValue()).getBikes();
				if (!listSelectionEvent.getValueIsAdjusting()) {
					SearchResultFrame srf = new SearchResultFrame(bikes, view);
				}
			}

		};
		list.addListSelectionListener(listSelectionListener);

		f.add(new JScrollPane(list));
		f.setSize(200, 500);
		f.setVisible(true);
	}

	public SearchResultFrame(final ArrayList<Bike> bikes, final BomsView view) {
		
		final String[] bikeArray = new String[bikes.size()];
		
		for (int i = 0 ; i < bikes.size(); i++){
			bikeArray[i] = bikes.get(i).toString();
		}

		JFrame f = new JFrame("Bikes");
		final JList list = new JList<String>(bikeArray);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionListener listSelectionListener = new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent listSelectionEvent) {
				if (!listSelectionEvent.getValueIsAdjusting()) {
					view.buttonPanel.printBarcodeButton.setBarcodeToBePrinted(bikes.get(list.getSelectedIndex()).getBarcode());
					view.buttonPanel.printBarcodeButton.setEnabled(true);
				}
			}

		};
		list.addListSelectionListener(listSelectionListener);
		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				view.buttonPanel.printBarcodeButton.setEnabled(false);
		    }
		});

		f.add(new JScrollPane(list));
		f.setSize(200, 500);
		f.setVisible(true);

	}
}
