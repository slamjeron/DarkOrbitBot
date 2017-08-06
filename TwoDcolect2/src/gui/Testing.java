package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import workingFinder.FindCargo;
import workingFinder.bonesBox;
import workingFinder.colectingTimers;

import javax.swing.JLabel;

public class Testing extends JFrame {

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
	 * @param cargo 
	 * @param cargo 
	 */
	public Testing(FindCargo cargo) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 234, 173);
		setUndecorated( true );
		setAlwaysOnTop(true);
		getRootPane().setWindowDecorationStyle(6 );
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		cargo.lblDirection.setBounds(10, 29, 130, 14);
		contentPane.add(cargo.lblDirection);
		
		cargo.lblNotMovingTime.setBounds(10, 54, 160, 14);
		contentPane.add(cargo.lblNotMovingTime);
		
		
		cargo.lblTravelTime.setBounds(10, 79, 100, 14);
		contentPane.add(cargo.lblTravelTime);
		
		
		cargo.lblShipXLocation.setBounds(10, 90, 170, 14);
		contentPane.add(cargo.lblShipXLocation);
	}

	
}
