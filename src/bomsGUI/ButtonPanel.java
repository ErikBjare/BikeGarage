package bomsGUI;

import java.awt.FlowLayout;
import javax.swing.*;



public class ButtonPanel extends JPanel {
	
	protected PrintBarcodeButton printBarcodeButton;

	public ButtonPanel(BomsView view) {
		printBarcodeButton = new PrintBarcodeButton(view);
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new AddButton(view));
		add(new RemoveButton(view));
		add(new SearchButton(view));
		add(new CheckedInButton(view));
		add(printBarcodeButton);
		
	}

}
