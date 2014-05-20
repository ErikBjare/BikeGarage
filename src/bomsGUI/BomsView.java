package bomsGUI;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.*;
import main.BarcodePrinterTestDriver;

public class BomsView{

	private ButtonPanel buttonPanel;
	private JTextArea messageArea;
	private BarcodePrinterTestDriver printer;

	public BomsView(String title, BarcodePrinterTestDriver printer) {

		this.printer = printer;
		
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		buttonPanel = new ButtonPanel(this, printer);
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
