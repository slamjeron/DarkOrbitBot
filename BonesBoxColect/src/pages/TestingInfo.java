package pages;

import java.awt.EventQueue;

import javax.swing.JFrame;

import takeAction.Timers;
import javax.swing.JLabel;

public class TestingInfo {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 * @param time 
	 */
	public TestingInfo(Timers time) {
		initialize(time);
	}

	/**
	 * Initialize the contents of the frame.
	 * @param time 
	 */
	private void initialize(Timers time) {
		frame = new JFrame();
		frame.setBounds(100, 100, 213, 228);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		time.lblShipHit.setBounds(10, 11, 158, 14);
		frame.getContentPane().add(time.lblShipHit);
		
		time.lblPetNotRepared.setBounds(10, 36, 155, 14);
		frame.getContentPane().add(time.lblPetNotRepared);
		
		time.lblOnMap.setBounds(10, 61, 154, 14);
		frame.getContentPane().add(time.lblOnMap);
		
		time.lblAbleToTravel.setBounds(10, 86, 152, 14);
		frame.getContentPane().add(time.lblAbleToTravel);
		
		
		time.lblRedyToRun.setBounds(10, 100, 150, 14);
		frame.getContentPane().add(time.lblRedyToRun);
		
		time.lblWateTime = new JLabel("wate time =");
		time.lblWateTime.setBounds(10, 134, 155, 14);
		frame.getContentPane().add(time.lblWateTime);
		
		time.lblCt = new JLabel("ct=");
		time.lblCt.setBounds(10, 164, 200, 14);
		frame.getContentPane().add(time.lblCt);
	}
}
