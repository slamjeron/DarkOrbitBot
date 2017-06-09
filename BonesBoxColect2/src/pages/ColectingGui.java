package pages;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import takeAction.Timers;

public class ColectingGui extends Timers{

	private JFrame frame;

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ColectingGui window = new ColectingGui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					//lets see what hapens
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	

	public ColectingGui() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private boolean start=true;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 233, 135);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		JButton btnTestMove = new JButton("start");
		btnTestMove.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//startBot();
				startSeeing();
				//System.out.println(Color.BLACK);
			}
		});
		btnTestMove.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnTestMove);

		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				stopPet();
				
			}
		});
		btnStop.setBounds(10, 45, 89, 23);
		frame.getContentPane().add(btnStop);
		

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenu mnStartPart = new JMenu("start part");
		mnFile.add(mnStartPart);

		JMenuItem mntmFlyTo = new JMenuItem("fly to 4-1");
		mntmFlyTo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//fly4_1();
				
			}
		});
		mnStartPart.add(mntmFlyTo);

		JMenuItem mntmDeterminIfDead = new JMenuItem("ded");
		mnStartPart.add(mntmDeterminIfDead);
		mntmDeterminIfDead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

	}
}
