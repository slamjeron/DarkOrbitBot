package gui;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;

public class ColectRobot {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColectRobot window = new ColectRobot();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ColectRobot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public int index =0;
	private boolean begin=true;
	
	private void initialize() {
		//colectingTimers cbox= new colectingTimers();
		
		
		frame = new JFrame();
		//frame.setUndecorated( true );
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 174, 173);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBackground(Color.red);
		btnStart.setForeground(Color.red);
		btnStart.addActionListener(new ActionListener() {
			private ColectingBot colectingBot=new ColectingBot();
			private boolean start=true;

			public void actionPerformed(ActionEvent arg0) {
				if(start){
				colectingBot.start();
				if(colectingBot.started){
				btnStart.setBackground(Color.GREEN);
				btnStart.setForeground(Color.GREEN);
				btnStart.setText("Start");
				start=false;
				}
				}else{
				colectingBot.stop();
				btnStart.setBackground(Color.red);
				btnStart.setForeground(Color.red);
				btnStart.setText("Stop");
				start=true;
				}
				
			}
		});
		btnStart.setBounds(20, 39, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		
		
		JLabel lblShipName = new JLabel("ship name=");
		lblShipName.setForeground(Color.GREEN);
		lblShipName.setBounds(10, 14, 63, 14);
		frame.getContentPane().add(lblShipName);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColectingBot.reset();
			}
		});
		btnReset.setBounds(20, 74, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		JMenuItem mntmTestPage = new JMenuItem("test page");
		mntmTestPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		mnFile.add(mntmTestPage);
		
		
	}
	private Point getRightCorner(Rectangle mapRect){
		return new Point(mapRect.x+mapRect.width,
				mapRect.y+mapRect.height);
	}
}
