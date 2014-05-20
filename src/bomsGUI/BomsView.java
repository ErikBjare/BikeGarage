package bomsGUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import (default package).BicycleGarageManager;

public class BomsView<BicycleGarageManager> {

	private ButtonPanel buttonPanel;
	private JTextArea messageArea;
	private BicycleGarageManager bicycleGarageManager;

	public BomsView(String title, BicycleGarageManager bicycleGaageManager) {
		this.bicycleGarageManager = bicycleGarageManager;
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new ButtonPanel(this);
		JPanel messagePanel = new JPanel();

		messageArea = new JTextArea(20, 100);
		messageArea.setEditable(false);
		messagePanel.add(new JScrollPane(messageArea));

		frame.add(buttonPanel, BorderLayout.WEST);
		frame.add(messagePanel, BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);

	}
}
