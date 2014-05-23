package bomsGUI;

import main.BarcodePrinterTestDriver;


public class BikeOwnerManagementSystem {
	
	private BarcodePrinterTestDriver printer;
	
	public BikeOwnerManagementSystem(){
		this.printer = new BarcodePrinterTestDriver();
		new LoginView("Login screen", this);
	}
	
	public static void main(String[] args) {
		new BikeOwnerManagementSystem();
	}

	public void printBarcode (String BicycleID){
		printer.printBarcode(BicycleID);
	}
}
