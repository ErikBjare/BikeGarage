package main;
import bomsGUI.BomsView;


public class BikeOwnerManagementSystem {

	public static void main(String[] args) {

		String title = "Bike Owner Management System";
		BicycleGarageManager bicycleGarageManager = new BicycleGarageManager(); 
		new BomsView(title, bicycleGarageManager);
	}

}
