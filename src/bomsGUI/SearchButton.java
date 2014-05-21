package bomsGUI;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;


public class SearchButton extends JButton implements ActionListener {
	private BomsView view;
	
	public SearchButton(BomsView view) {
		super("Search");
		this.view = view;
		addActionListener(this);
		setToolTipText("Search after a bike owner");
	}
	
	public void actionPerformed(ActionEvent e){
		
		String[] data = {"aaa","bbb","ccc","ddd","eee",
			            "fff","ggg","hhh","iii","jjj"};
		
		String ssnOrName = JOptionPane
				.showInputDialog("Enter SSN or name of the bike owner");
		if (ssnOrName == null) {
			return;
		} else if(ssnOrName.equals("Filip") || ssnOrName.equals("01") ) {
			JFrame f = new JFrame();
			f.add(new JScrollPane(new JList(data)));
			f.setSize(100,100);
			f.setVisible(true);
		}
		
		//TODO
	}
	

}
