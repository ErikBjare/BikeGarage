package bomsGUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import db.DatabaseManager;

public class LockedView extends JFrame{
	
	private JTextArea messageArea;
	private JButton refreshButton;
	public LockedView(String title){
		super(title);
		
		refreshButton = new JButton();
		JPanel messagePanel = new JPanel();
		messageArea = new JTextArea(5, 30);
		messageArea.setEditable(false);
		messageArea.setText("\nYou entered the wrong login details too many times, try again ");
	
		
		messagePanel.add(messageArea);
		add(messagePanel);
		
		pack();
		setVisible(true);
		
	}
	// Gives the database a time locked
	public void setTime(){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 10);
    	DatabaseManager.setLockedTime(cal);  
	}
	
	

}
