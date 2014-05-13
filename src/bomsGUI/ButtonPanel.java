package bomsGUI;
import java.awt.FlowLayout;

import javax.swing.*;

public class ButtonPanel extends JPanel {

	public ButtonPanel(bomsView view) {
//		setLayout(new FlowLayout(FlowLayout.TOP));
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new addButton(view));
		add(new removeButton(view));
		add(new searchButton(view));
		add(new printBarcodeButton(view));
		add(new checkedInButton(view));
		add(new logOutButton(view));
	}

}
