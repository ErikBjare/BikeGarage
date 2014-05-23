package bomsGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class BomsView extends JFrame {

	protected ButtonPanel buttonPanel;
	private JTextArea messageArea;
	protected BikeOwnerManagementSystem boms;

	public BomsView(String title, BikeOwnerManagementSystem boms) {

		this.boms = boms;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new ButtonPanel(this);

		JPanel messagePanel = new JPanel();
		messageArea = new JTextArea(20, 100);
		messageArea.setEditable(false);
		messagePanel.add(new JScrollPane(messageArea));

		add(buttonPanel, BorderLayout.WEST);

		add(messagePanel, BorderLayout.CENTER);
		buttonPanel.add(new LogOutButton(this));
		pack();
		setVisible(true);
		


	}

	public void setText(String s) {
		messageArea.setText(s);
	}


	public class LogOutButton extends JButton implements ActionListener {
		private BomsView view;

		public LogOutButton(BomsView view) {
			super("Log Out");
			this.view = view;
			addActionListener(this);
			setToolTipText("Log out.");
		}

		public void actionPerformed(ActionEvent e) {

			Object[] options2 = { "Yes", "No" };
			int m = JOptionPane.showOptionDialog(null,
					"Do you want to log out?",  "Log Out",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options2, options2[0]);
			if (m == 0) {
				new LoginView("Login screen", view.boms);
				view.dispose();
			}

		}

	}

}
