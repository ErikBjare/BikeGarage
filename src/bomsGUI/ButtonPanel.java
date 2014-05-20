package bomsGUI;

import java.awt.FlowLayout;
import main.BarcodePrinterTestDriver;
import javax.swing.*;

public class ButtonPanel extends JPanel {

	public ButtonPanel(BomsView view, BarcodePrinterTestDriver printer) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new AddButton(view, printer));
		add(new RemoveButton(view));
		add(new SearchButton(view, printer));
		add(new PrintBarcodeButton(view, printer));
		add(new CheckedInButton(view));
		add(new LogOutButton(view));
	}

}
