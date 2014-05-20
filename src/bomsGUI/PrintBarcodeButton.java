package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class PrintBarcodeButton extends JButton implements ActionListener {
	private BomsView view;
	
	public PrintBarcodeButton(BomsView view) {
		super("Print Barcode");
		this.view = view;
		this.setEnabled(false);
		addActionListener(this);
		setToolTipText("Prints a barcode.");
	}
	
	public void actionPerformed(ActionEvent e){
		view.boms.printBarcode("generateBarcode");
		//ToDo
	}

}
