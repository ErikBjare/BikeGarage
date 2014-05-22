package bomsGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

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

	public LoginView(String title,
			final BikeOwnerManagementSystem bikeOwnerManagementSystem) {
		super(title);

		text1 = new JTextField(); // Kan ge dem en int parameter för maxtecken
		pass1 = new JPasswordField();

		nameLabel = new JLabel("Username");
		passwordLabel = new JLabel("Password"); // Passwodfield

		loginButton = new JButton("Login");
		cancelButton = new JButton("Cancel");

		panel = new JPanel(new GridLayout(3, 2));
		panel.add(nameLabel);
		panel.add(text1);
		panel.add(passwordLabel);
		panel.add(pass1);
		panel.add(loginButton);
		panel.add(cancelButton);

		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String username = text1.getText();
				char[] pass = pass1.getPassword();
				String password = new String(pass);

				if (DatabaseManager.getPassword().equals(password)
						&& DatabaseManager.getUsername().equals(username)) {
					
					new BomsView("BOMS view", bikeOwnerManagementSystem);
					
					DatabaseManager.correctLogin();
					dispose();
				} else if (DatabaseManager.wrongLogin() == 10) {
					loginButton.setEnabled(false);
				} else {
					pass1.setText("");
				}

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
