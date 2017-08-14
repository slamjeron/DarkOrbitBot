package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.image.BufferedImage;
import userControls.GetImage;
import userControls.Timers;
import userControls.textReader;
import javax.swing.event.ChangeEvent;

public class ColectRobot {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public ColectRobot() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public boolean start=false;
	public int index =0;
	private boolean begin=true;
	
	private void initialize() {
		//colectingTimers cbox= new colectingTimers();
		textReader txt=new textReader();
		
		frame = new JFrame();
		//frame.setUndecorated( true );
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 198, 164);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GetImage img=new GetImage();
				
				BufferedImage im = img.screanImage();
				
				txt.start(im);
				
				if(txt.userFound&&txt.petFound&&
						txt.shipFound&&txt.mapFound){
				if(begin){
					Timers timer = new Timers(txt,img);
				}
				}
			}
		});
		btnStart.setBounds(33, 42, 89, 23);
		frame.getContentPane().add(btnStart);
		
		
		
		
		JLabel lblShipName = new JLabel("ship name=");
		lblShipName.setForeground(Color.GREEN);
		lblShipName.setBounds(10, 14, 63, 14);
		frame.getContentPane().add(lblShipName);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		Playerinfo Pinfo=new Playerinfo(txt.dispInfo);
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		JMenuItem mntmTestPage = new JMenuItem("test page");
		mntmTestPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				Pinfo.setVisible(true);
			}
		});
		
		
		mnFile.add(mntmTestPage);
		
		
	}
}
