package bomsGUI;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;




public class bomsView {
	
	private ButtonPanel buttonPanel;
	private JTextArea messageArea;
	
	
	public bomsView(String title){
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setLayout(new FlowLayout(FlowLayout.LEFT));
		buttonPanel = new ButtonPanel(this);
		JPanel messagePanel = new JPanel();
		
		messageArea = new JTextArea(20, 100);
		messageArea.setEditable(false);
		messagePanel.add(new JScrollPane (messageArea));

		
		
		frame.add(buttonPanel, BorderLayout.WEST);
		frame.add(messagePanel, BorderLayout.CENTER);
		
		frame.pack();
		frame.setVisible(true);
		
	}


	private void setLayout(FlowLayout flowLayout) {
		// TODO Auto-generated method stub
		
	}
}
