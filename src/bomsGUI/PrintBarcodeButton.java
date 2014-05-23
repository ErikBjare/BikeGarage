package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class PrintBarcodeButton extends JButton implements ActionListener {
	private BomsView view;
	private String barcode;
	
	public PrintBarcodeButton(BomsView view) {
		super("Print Barcode");
		this.view = view;
		this.setEnabled(false);
		addActionListener(this);
		setToolTipText("Prints a barcode.");
	}
	
	public void actionPerformed(ActionEvent e){
		view.boms.printBarcode(barcode);
		this.setEnabled(false);
	}
	
	public void setBarcodeToBePrinted(String barcode){
		this.barcode = barcode;
	}

}
