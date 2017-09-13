package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import time.ColectTimers;

import java.awt.Color;

public class developertest extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	//protected colectingTimers box1;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 * @param colectTime 
	 * @param box1 
	 * @param cargo 
	 * @param cargo 
	 */
	public developertest(ColectTimers colectTime) {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 234, 188);
		setUndecorated( true );
		setAlwaysOnTop(true);
		getRootPane().setWindowDecorationStyle(6 );
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		colectTime.lblBacedetect.setBounds(10,8, 130, 14);
		contentPane.add(colectTime.lblBacedetect);
		colectTime.lblBacedetect.setForeground(Color.WHITE);
		
		/*cargo.lblNotMovingTime.setBounds(10, 30, 160, 14);
		contentPane.add(cargo.lblNotMovingTime);
		cargo.lblNotMovingTime.setForeground(Color.WHITE);
		
		cargo.lblTravelTime.setBounds(10,50, 100, 14);
		contentPane.add(cargo.lblTravelTime);
		cargo.lblTravelTime.setForeground(Color.WHITE);
		
		cargo.lblShipXLocation.setBounds(10, 70, 170, 14);
		contentPane.add(cargo.lblShipXLocation);
		cargo.lblShipXLocation.setForeground(Color.WHITE);
		
		box1.lblDeathCount.setBounds(10, 90, 170, 14);
		contentPane.add(box1.lblDeathCount);
		box1.lblDeathCount.setForeground(Color.WHITE);
		
		box1.lblStallTime.setBounds(10, 110, 170, 14);
		contentPane.add(box1.lblStallTime);
		box1.lblStallTime.setForeground(Color.WHITE);*/
		
	}
}
