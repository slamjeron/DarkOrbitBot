package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import workingFinder.colectingTimers;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import userControls.Keyboard;
import userControls.Mouse;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
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
	private void initialize() {
		//colectingTimers cbox= new colectingTimers();
		
		colectingTimers box1=new colectingTimers();
		frame = new JFrame();
		frame.setUndecorated( true );
		frame.getRootPane().setWindowDecorationStyle(6 );
		frame.setBackground(Color.BLUE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 215, 192);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setAlwaysOnTop(true);
		JComboBox<Object> comboBox = new JComboBox<Object>();
		
		comboBox.addItemListener(new ItemListener() {
			

			public void itemStateChanged(ItemEvent arg0) {
				index =comboBox.getSelectedIndex();
				box1.setIndex(index);
				if(start){
				box1.shair.cargo.travel.sethight(index);
				}
			}
		});
		
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String[] {"normal Colect", "enimy has base", "moving"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(27, 11, 128, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				start=true;
					box1.colect();
					box1.shair.cargo.travel.sethight(index);
			}
		});
		btnStart.setBounds(37, 42, 89, 23);
		frame.getContentPane().add(btnStart);
		
		JButton btnSkipStall = new JButton("skip stall");
		btnSkipStall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				box1.setWTime();
			}
		});
		btnSkipStall.setBounds(37, 76, 89, 23);
		frame.getContentPane().add(btnSkipStall);
		
		JSpinner spinner = new JSpinner();
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				box1.setStallTime((int) spinner.getValue());
			}
		});
		spinner.setModel(new SpinnerNumberModel(new Integer(5), new Integer(1), null, new Integer(1)));
		spinner.setBounds(118, 119, 53, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblStallTime = new JLabel("stall time =");
		lblStallTime.setForeground(Color.GREEN);
		lblStallTime.setBounds(59, 122, 67, 14);
		frame.getContentPane().add(lblStallTime);
		
		JLabel lblMin = new JLabel("min");
		lblMin.setForeground(Color.GREEN);
		lblMin.setBounds(173, 122, 67, 14);
		frame.getContentPane().add(lblMin);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("file");
		menuBar.add(mnFile);
		developertest test=new developertest(box1,box1.shair.cargo); 
		JMenuItem mntmTestPage = new JMenuItem("test page");
		mntmTestPage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				test.setVisible(true);
			}
		});
		
		
		mnFile.add(mntmTestPage);
		
		
	}
}
