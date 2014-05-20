package main;
import bomsGUI.BomsView;


public class BikeOwnerManagementSystem {

	public static void main(String[] args) {
		
		String title = "Bike Owner Management System";
		new BomsView(title, new BarcodePrinterTestDriver());
		
	}

}
