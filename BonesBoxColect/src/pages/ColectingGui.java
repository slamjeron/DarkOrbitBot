package pages;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import takeAction.Timers;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

public class ColectingGui {

	private JFrame frame;

	Timers time=new Timers();

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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 245, 171);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		JButton btnTestMove = new JButton("start");
		btnTestMove.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//startBot();
				time.startSeeing();
				//System.out.println(Color.BLACK);
			}
		});
		btnTestMove.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnTestMove);

		JButton btnStop = new JButton("stop");
		btnStop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				time.stopPet();
			}
		});
		btnStop.setBounds(10, 45, 89, 23);
		frame.getContentPane().add(btnStop);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time.searcharea=comboBox.getSelectedIndex();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"all map", "top map", "search map ", "auto"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(120, 46, 75, 20);
		frame.getContentPane().add(comboBox);
		
		JLabel lblWhereSearch = new JLabel("where search");
		lblWhereSearch.setBounds(120, 15, 75, 14);
		frame.getContentPane().add(lblWhereSearch);
		
		JCheckBox chckCompleteAuto = new JCheckBox("compleat aughto");
		chckCompleteAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time.runf.nothear=chckCompleteAuto.isSelected();
			}
		});
		chckCompleteAuto.setBounds(20, 75, 141, 23);
		frame.getContentPane().add(chckCompleteAuto);
		

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
		TestingInfo test = new TestingInfo(time);
		JMenuItem mntmShowTestingPage = new JMenuItem("show testing page");
		mntmShowTestingPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				test.frame.setVisible(true);
			}
		});
		mnFile.add(mntmShowTestingPage);
		mntmDeterminIfDead.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});

	}
}
