package bomsGUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.*;

import db.Bike;
import db.BikeOwner;

public class RegistrationForm extends JFrame {

	private JPanel panel;
	private JLabel nameLabel, emailLabel;
	private JTextField text1, text2;
	private JButton submitButton;
	private JButton cancelButton;
	private String ssn;

	// String name;
	// String email;

	public RegistrationForm(String title, String ssn) {
		super(title);
		this.ssn = ssn;

		text1 = new JTextField(); // Kan ge dem en int parameter för maxtecken
		text2 = new JTextField();

		nameLabel = new JLabel("Name");
		emailLabel = new JLabel("Email");

		submitButton = new JButton("Submit");
		cancelButton = new JButton("Cancel");

		panel = new JPanel(new GridLayout(3, 2));
		panel.add(nameLabel);
		panel.add(text1);
		panel.add(emailLabel);
		panel.add(text2);
		panel.add(submitButton);
		panel.add(cancelButton);

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String name = text1.getText();
				String email = text2.getText();

				BikeOwner toBeAdded = new BikeOwner(name, getSsn(), email);
				toBeAdded.addBike(new Bike(toBeAdded, "id"));
				// TODO
				// Save bikeowner & bike
				dispose();
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

	public String getSsn() {
		return ssn;
	}
}
