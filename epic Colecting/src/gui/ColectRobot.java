package gui;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

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
	private boolean start=true;
	private ColectingBot colectingBot=new ColectingBot();
	private Image img; 	
	private void initialize() {
		//colectingTimers cbox= new colectingTimers();
		
		
		frame = new JFrame();
		//frame.setUndecorated( true );
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 222, 173);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		
		JButton btnStart = new JButton("START");
		btnStart.setBackground(Color.GREEN);
		btnStart.setForeground(Color.BLACK);
		btnStart.addActionListener(new ActionListener() {
			
			

			public void actionPerformed(ActionEvent arg0) {
				if(start){
				colectingBot.start();
				if(colectingBot.started){
				btnStart.setBackground(Color.RED);
				btnStart.setText("STOP");
				start=false;
				
				}
				}else{
				colectingBot.stop();
				btnStart.setBackground(Color.GREEN);
				btnStart.setText("START");
				start=true;
				}
				
			}
		});
		btnStart.setBounds(20, 39, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		
		
		JLabel lblShipName = new JLabel("ship nm");
		lblShipName.setForeground(Color.GREEN);
		lblShipName.setBounds(10, 14, 63, 14);
		frame.getContentPane().add(lblShipName);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colectingBot.stop();
				colectingBot=new ColectingBot();
				btnStart.setBackground(Color.GREEN);
				btnStart.setText("START");
				start=true;
			}
		});
		btnReset.setBounds(20, 74, 89, 23);
		frame.getContentPane().add(btnReset);
		
		JButton btnTopScreen = new JButton("");
		
		btnTopScreen.addActionListener(new ActionListener() {
			private boolean top=false;

			public void actionPerformed(ActionEvent arg0) {
				if(!top){
						btnTopScreen.setIcon(new ImageIcon(getClass().getResource("/Arrow-Up-icon (1).png")));	
						
				}else{
							btnTopScreen.setIcon(new ImageIcon(getClass().getResource("/Arrow-Down-icon.png")));	
											
				}
				top=!top;
			}
		});
		btnTopScreen.setBorder(null);
		btnTopScreen.setBackground(Color.BLACK);
		btnTopScreen.setOpaque(false);
		
		btnTopScreen.setIcon(new ImageIcon(getClass().getResource("/Arrow-Up-icon (1).png")));
		btnTopScreen.setBounds(151, 34, 46, 42);
		frame.getContentPane().add(btnTopScreen);
		
		JLabel lblColect = new JLabel("colect");
		lblColect.setForeground(Color.GREEN);
		lblColect.setBounds(114, 43, 46, 14);
		frame.getContentPane().add(lblColect);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		JMenuItem mntmTestPage = new JMenuItem("test page");
		mntmTestPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					//test.setVisible(true);	
			}
		});
		
		
		mnFile.add(mntmTestPage);
		
		
	}
}
