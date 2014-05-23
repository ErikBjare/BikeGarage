package bomsGUI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import db.DatabaseManager;

public class LockedView{
	
	Calendar cal;

	public LockedView() throws InterruptedException{
			
	
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		cal = Calendar.getInstance();
		cal.add(Calendar.MINUTE, 10);
		
		JOptionPane.showMessageDialog(null,"You entered the login details too many times, the system will be locked until " + sdf.format(cal.getTime()));
		
		setTime();
	}
	// Gives the database a time which shows when the loginbutton can be unlocked
	public void setTime(){
    	DatabaseManager.setLockedTime(cal); 
     }
	
	
	

}
