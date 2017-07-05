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
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

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
		frame.setBounds(100, 100, 232, 227);
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
		time.runf.nothear=true;
		JCheckBox chckCompleteAuto = new JCheckBox("compleat aughto");
		chckCompleteAuto.setSelected(true);
		chckCompleteAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				time.runf.nothear=chckCompleteAuto.isSelected();
			}
		});
		chckCompleteAuto.setBounds(56, 73, 141, 23);
		frame.getContentPane().add(chckCompleteAuto);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				time.psw=(int) spinner.getValue();
			}
		});
		spinner.setModel(new SpinnerNumberModel(new Integer(7), new Integer(1), null, new Integer(1)));
		spinner.setBounds(80, 119, 46, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblPetSearch = new JLabel("pet search");
		lblPetSearch.setBounds(10, 107, 60, 14);
		frame.getContentPane().add(lblPetSearch);
		
		JLabel lblWidth = new JLabel("width");
		lblWidth.setBounds(89, 94, 46, 14);
		frame.getContentPane().add(lblWidth);
		
		JLabel lblHight = new JLabel("hight");
		lblHight.setBounds(147, 94, 46, 14);
		frame.getContentPane().add(lblHight);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				time.psh=(int) spinner_1.getValue();
			}
		});
		spinner_1.setModel(new SpinnerNumberModel(new Integer(5), new Integer(1), null, new Integer(1)));
		spinner_1.setBounds(136, 119, 46, 20);
		frame.getContentPane().add(spinner_1);
		

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
