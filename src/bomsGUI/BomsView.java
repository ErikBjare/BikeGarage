package bomsGUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;

public class BomsView{

	private ButtonPanel buttonPanel;
	private JTextArea messageArea;
	protected SearchSelectionPanel searchSelectionPanel;
	protected BikeOwnerManagementSystem boms;

	public BomsView(String title, BikeOwnerManagementSystem boms) {
		
		this.boms = boms;
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new ButtonPanel(this);
		
		searchSelectionPanel = new SearchSelectionPanel(this);

		JPanel messagePanel = new JPanel();
		messageArea = new JTextArea(20, 100);
		messageArea.setEditable(false);
		messagePanel.add(new JScrollPane(messageArea));
		
		frame.add(buttonPanel, BorderLayout.WEST);
		frame.add(searchSelectionPanel, BorderLayout.SOUTH);
		frame.add(messagePanel, BorderLayout.CENTER);
		

		frame.pack();
		frame.setVisible(true);

	}
	
	public void setText(String s){
		messageArea.setText(s);
	}
}
