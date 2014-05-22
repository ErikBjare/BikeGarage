package bomsGUI;

import javax.swing.*;

import java.awt.event.*;

public class RefreshLockedButton extends JButton implements ActionListener {

	public RefreshLockedButton(LockedView view) {
		super("Refresh");

		addActionListener(this);
		setToolTipText("Locked Mode Timer Refresh");

	}

	public void actionPerformed(ActionEvent e) {

	}

}
