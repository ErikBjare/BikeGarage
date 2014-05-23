package bomsGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Calendar;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;
import db.DatabaseManager;

public class LoginView extends JFrame {

	private JPanel panel;
	private JLabel nameLabel, passwordLabel;
	private JTextField text1;
	private JPasswordField pass1;
	private JButton loginButton;
	private JButton cancelButton;
	private LockedView lockedView;

	public LoginView(String title,
			final BikeOwnerManagementSystem bikeOwnerManagementSystem) {
		super(title);

		text1 = new JTextField(); 
		pass1 = new JPasswordField();

		nameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password");

		loginButton = new JButton("Login");
		cancelButton = new JButton("Cancel");

		panel = new JPanel(new GridLayout(3, 2));
		panel.add(nameLabel);
		panel.add(text1);
		panel.add(passwordLabel);
		panel.add(pass1);
		panel.add(loginButton);
		panel.add(cancelButton);
		
		loginButton.doClick();
			
			if (DatabaseManager.getDBM().getLockedTime() != null // if still waiting for unlocking system
					&& DatabaseManager.getDBM().getLockedTime()
							.compareTo(Calendar.getInstance()) >= 0) {
				
				System.out.println("t");
			}
			
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				System.out.println("tt");
				String username = text1.getText();
				char[] pass = pass1.getPassword();
				String password = new String(pass);
				
				
				if (DatabaseManager.wrongLogin() >= 9) { // Wrong login
					lockSystem();
					DatabaseManager.correctLogin();
				} else if (DatabaseManager.getPassword().equals(password)
						&& DatabaseManager.getUsername().equals(username)) {

					new BomsView("BOMS view", bikeOwnerManagementSystem);

					DatabaseManager.correctLogin();
					dispose();
				} else {
					pass1.setText("");
				}

			
				
			}
			public boolean systemIsLocked() {
				if(DatabaseManager.getDBM().getLockedTime() != null){
				return DatabaseManager.getDBM().getLockedTime().compareTo(
						Calendar.getInstance()) >= 0;
				}else return false;
			}

			public void lockSystem() {
				loginButton.setEnabled(false);

				try {
					lockedView = new LockedView();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}

				Calendar cal = DatabaseManager.getDBM().getLockedTime();
				

				while (systemIsLocked()) {

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				}
				loginButton.setEnabled(true);
				DatabaseManager.correctLogin();

			}
		});
	

		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		add(panel);
		setSize(300, 200);
		setVisible(true);

	}

}
