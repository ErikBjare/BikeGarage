package bomsGUI;

import java.awt.FlowLayout;
import javax.swing.*;

public class ButtonPanel extends JPanel {

	public ButtonPanel(BomsView view) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new AddButton(view));
		add(new RemoveButton(view));
		add(new SearchButton(view));
		add(new PrintBarcodeButton(view));
		add(new CheckedInButton(view));
		add(new LogOutButton(view));
	}

}
