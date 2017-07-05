package testPages;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DrawshipPoint {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DrawshipPoint window = new DrawshipPoint();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DrawshipPoint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Timers time = new Timers();
		frame = new JFrame();
		frame.setBounds(100, 100, 532, 318);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time.showShipPNT();
			}
		});
		btnStart.setBounds(10, 26, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		time.lblMap.setBounds(109, 30, 368, 238);
		frame.getContentPane().add(time.lblMap);
		
		
		time.label.setBounds(10, 91, 89, 14);
		frame.getContentPane().add(time.label);
	}
	
}
