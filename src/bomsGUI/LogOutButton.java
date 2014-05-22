package bomsGUI;

import javax.swing.*;
import java.awt.event.*;


public class LogOutButton extends JButton implements ActionListener {
	private BomsView view;
	
	public LogOutButton(BomsView view) {
		super("Log Out");
		this.view = view;
		addActionListener(this);
		setToolTipText("Log out.");
	}
	
	public void actionPerformed(ActionEvent e){
		LoginView loginView = new LoginView("Login", view.boms);
		view.dispose();
	}

}
