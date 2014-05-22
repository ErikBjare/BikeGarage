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
		cal.add(Calendar.SECOND, 10);
		String lockedTime = sdf.format(cal.getTime());
		
		JOptionPane.showMessageDialog(null,"You entered the login details too many times, the system will be locked until " + lockedTime);
		
		setTime();
	}
	// Gives the database a time locked
	public void setTime(){
    	DatabaseManager.setLockedTime(cal); 
     }
	
	
	

}
